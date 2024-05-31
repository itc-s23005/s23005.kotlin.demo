package jp.ac.it_college.std.s23005.demo

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("greeter")
class GreeterController (
    private val greeter: Greeter,
    @Qualifier("JapaneseMessageService")
    private val messageService: MessageService
){
    @GetMapping("/welcom")
    fun welcom(): HelloResponse {
        return HelloResponse(messageService.welcom())
    }

    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String) : HelloResponse {
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }

    @GetMapping("/hello")
    fun hello(@RequestParam("name")name: String): HelloResponse{
        return HelloResponse("Hello $name")
    }

    @PostMapping("/hello")
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse{
        return HelloResponse("Hello ${request.name}")
    }

    @GetMapping("/hello/{name}")
    fun HelloPoathValue(@PathVariable("name") name: String): HelloResponse{
        return HelloResponse("Hello $name")
    }
}
