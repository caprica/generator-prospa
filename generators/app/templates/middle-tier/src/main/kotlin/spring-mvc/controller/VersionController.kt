package <%= packageName %>.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * An example web service API controller.
 */
@RestController
class VersionController {

    @GetMapping(value = ["/api/version"])
    fun version(): String {
        return "{\"version\": \"1.0.0\"}"
    }

}
