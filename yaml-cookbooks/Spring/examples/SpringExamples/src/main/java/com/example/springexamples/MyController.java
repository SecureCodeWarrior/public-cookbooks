package com.example.springexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    @Autowired
    private MyInjectedService myInjectedService;

    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    public void checkService() {
        myService.doSomething();
        myInjectedService.doSomething();
    }
}
