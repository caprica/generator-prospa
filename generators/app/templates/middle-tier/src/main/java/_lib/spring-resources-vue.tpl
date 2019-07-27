        // Mappings for static resources
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/app/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/app/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/app/img/");
        registry.addResourceHandler("/*.ico").addResourceLocations("classpath:/app/");
