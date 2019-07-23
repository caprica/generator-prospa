package <%= packageName %>.config

import javax.servlet.ServletContext
import javax.servlet.ServletException

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

/**
 * Automatic initialisation class for our application.
 *
 * This class is discovered at run-time by the servlet container and will bootstrap the application.
 *
 * Some aspects of the application are initialised by the associated [SpaWebAppConfiguration] class.
 *
 * Key features:
 *
 *  - The web application is mapped to the root "/" context
 *  - All static resources are under the "/assets/" path
 *  - A request for "index.html" will redirect to "/" for a nicer URL in the address bar
 *  - All web-service API are under an "/api/" path
 *  - A request for an unknown API will have a catch-all that maps to a BAD_REQUEST response
 *  - Any other request, including deep-link requests, will map to the single page web application for client routing
 *
 * The names for the path prefixes used here are arbitrary and can be changed to whatever you prefer.
 */
class SpaWebAppInitializer : WebApplicationInitializer {

    @Throws(ServletException::class)
    override fun onStartup(servletContext: ServletContext) {
        // Create an application context using our configuration class
        val context = AnnotationConfigWebApplicationContext()
        context.servletContext = servletContext
        context.register(SpaWebAppConfiguration::class.java)
        context.refresh()

        // Create and register the SpringMVC dispatcher servlet
        val servlet = DispatcherServlet(context)
        val registration = servletContext.addServlet(SERVLET_NAME, servlet)
        registration.setLoadOnStartup(1)
        registration.addMapping(SERVLET_MAPPING)
    }

    companion object {

        // Name for the servlet, does not really matter what it is
        private val SERVLET_NAME = "app"

        // Map the SpringMVC servlet to the default context root
        private val SERVLET_MAPPING = "/"

    }

}
