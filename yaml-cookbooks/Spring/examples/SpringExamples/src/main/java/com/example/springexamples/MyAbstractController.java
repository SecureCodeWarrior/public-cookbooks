package com.example.springexamples;

import org.springframework.stereotype.Controller;

@Controller
public abstract class MyAbstractController {

    private MyService myService;

    public MyAbstractController(MyService myService) {
        this.myService = myService;
    }
}
