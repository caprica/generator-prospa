package <%= packageName %>.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Single page web application configuration.
 * <p>
 * Due to how this web application is configured, we need to make sure that the resource handler mappings are tried
 * before the controller mappings (by default the resource handler mappings are tried <em>after</em> the controller
 * mappings.
 * <p>
 * This is necessary because we use the catch-all "/**" mapping to route everything to the single page web application
 * for client routing - if the ordering was not properly set the request for "index.html" for the single page web
 * application would be infinitely looped to the catch-all controller until the stack overflowed.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "<%= packageName %>.controller",
    "<%= packageName %>.service",
    "<%= packageName %>.repository"
})
public class SpaWebAppConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Cache control is NOT set here in this example project, but will likely be useful in a real application

        // It might still be handy to route to a static assets directory on the server (e.g. for images, or scripts or
        // css that is not part of the single page application)
        registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");

        // In the classpath locations referenced here, "app" is the output directory that is configured for the
        // maven-resources-plugin in the pom - the name is arbitrary - when the client application is built it is copied
        // to this directory

        // Explicitly map a request for the index.html page to the published client application main page (this is the
        // mapping for the "forward:/index.html" view controller below)
        registry.addResourceHandler("/index.html").addResourceLocations("classpath:/app/index.html");

<%- include(`../../_lib/spring-resources-${frontEnd}.tpl`) -%>

        // We want the resource handlers to be tried before the controllers (the particular number does not really
        // matter, but it must be lower than the corresponding controller registry order)
        registry.setOrder(-1000);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // We do not have a redirect here from "index.html" to "/" for two reasons:
        //  1. the resource handlers now by design have higher priority than the view controllers, so the "/index.html"
        //     mapping in the resource handlers will override any "/index.html" mapping here
        //  2. it does not matter anyway because we can have the client application router simply redirect "/index.html"
        //     to the application root to keep the address bar clean

        // A catch-all for the web-service API routes to respond with the BAD_REQUEST status code
        registry.addStatusController("/api/**", HttpStatus.BAD_REQUEST);

        // A catch-all for everything else to forward to the single page web application, client routing will take over
        registry.addViewController("/**").setViewName("forward:/index.html");

        // We want the controllers to be tried after the resource handlers (the particular number does not really
        //  matter, but it must be higher than the corresponding resource registry order)
        registry.setOrder(1000);
    }
}
