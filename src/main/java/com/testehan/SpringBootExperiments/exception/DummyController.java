package com.testehan.SpringBootExperiments.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// this is a dummy controller that has an endpoint that intentionally throws a custom exception.
// we will see a nice way of how to handle exceptions in Spring.

@RestController
@RequestMapping(path = "api/v1/exception")
public class DummyController {

    @GetMapping
    public String getMessage(){
//        throw new IllegalArgumentException("can't get the message");
        throw new ApiRequestException("can't get message. See custom exception message for more details");
    }
}
