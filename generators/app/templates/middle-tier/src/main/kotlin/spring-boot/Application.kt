package <%= packageName %>

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class <%= mainClassName %> {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(<%= mainClassName %>::class.java, *args)
        }

    }

}
