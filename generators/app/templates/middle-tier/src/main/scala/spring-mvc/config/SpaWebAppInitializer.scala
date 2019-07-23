package <%= packageName %>.config

import javax.servlet.ServletContext
import javax.servlet.ServletException

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

/**
  * Automatic initialisation class for our application.
  * <p>
  * This class is discovered at run-time by the servlet container and will bootstrap the application.
  * <p>
  * Some aspects of the application are initialised by the associated {@link SpaWebAppConfiguration} class.
  * <p>
  * Key features:
  * <ul>
  * <li>The web application is mapped to the root "/" context</li>
  * <li>All static resources are under the "/assets/" path</li>
  * <li>A request for "index.html" will redirect to "/" for a nicer URL in the address bar</li>
  * <li>All web-service API are under an "/api/" path</li>
  * <li>A request for an unknown API will have a catch-all that maps to a BAD_REQUEST response</li>
  * <li>Any other request, including deep-link requests, will map to the single page web application for client
  * routing</li>
  * </ul>
  * The names for the path prefixes used here are arbitrary and can be changed to whatever you prefer.
  */
object SpaWebAppInitializer {

    // Name for the servlet, does not really matter what it is
    private val SERVLET_NAME = "app"

    // Map the SpringMVC servlet to the default context root
    private val SERVLET_MAPPING = "/"

}

class SpaWebAppInitializer extends WebApplicationInitializer {

    @throws[ServletException]
    override def onStartup(servletContext: ServletContext): Unit = {
        // Create an application context using our configuration class
        val context = new AnnotationConfigWebApplicationContext
        context.setServletContext(servletContext)
        context.register(classOf[SpaWebAppConfiguration])
        context.refresh()

        // Create and register the SpringMVC dispatcher servlet
        val servlet = new DispatcherServlet(context)
        val registration = servletContext.addServlet(SpaWebAppInitializer.SERVLET_NAME, servlet)
        registration.setLoadOnStartup(1)
        registration.addMapping(SpaWebAppInitializer.SERVLET_MAPPING)
    }

}
