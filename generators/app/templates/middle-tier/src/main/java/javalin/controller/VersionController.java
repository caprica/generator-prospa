package <%= packageName %>.controller;

import io.javalin.http.Handler;

/**
 * An example web service API controller.
 */
public class VersionController {

    public static Handler version = ctx -> ctx.json("{\"version\": \"1.0.0\"}");

}
