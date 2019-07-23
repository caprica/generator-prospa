package <%= packageName %>.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * An example web service API controller.
 */
@RestController
public class VersionController {

    @GetMapping(value = "/api/version")
    public String version() {
        return "{\"version\": \"1.0.0\"}";
    }

}
