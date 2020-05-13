package no.repairable.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/helloworld")
class HelloWorldController {

    @GetMapping("")
    fun hello() = "Hello world"

}
