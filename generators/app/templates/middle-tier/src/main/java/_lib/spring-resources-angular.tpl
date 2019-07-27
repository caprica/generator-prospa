        // The client application build uses a "static" directory to contain CSS, JS and media files
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/app/static/");

        // Unfortunately these special-case explicit mappings are required for the client application support files in
        // the root directory (like the manifest json, the service worker script and so on) - this is to make sure we
        // can still map correctly to these files and keep our catch-all request mapping
        registry.addResourceHandler("/*.ico").addResourceLocations("classpath:/app/");
        registry.addResourceHandler("/*.js").addResourceLocations("classpath:/app/");
        registry.addResourceHandler("/*.map").addResourceLocations("classpath:/app/");
