package <%= packageName %>.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
  * An example web service API controller.
  */
@RestController
class VersionController {

    @GetMapping(value = Array("/api/version"))
    def version = "{\"version\": \"1.0.0\"}"

}
