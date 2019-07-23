package <%= packageName %>

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.web.bind.annotation.GetMapping

import <%= packageName %>.config.SpaWebAppConfiguration

@SpringBootApplication
class <%= mainClassName %>

object Main {

    def main(args: Array[String]): Unit = SpringApplication.run(classOf[<%= mainClassName %>])

}
