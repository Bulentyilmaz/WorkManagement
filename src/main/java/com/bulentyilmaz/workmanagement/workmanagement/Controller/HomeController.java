package com.bulentyilmaz.workmanagement.workmanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value ={ "/","/home"})
    public String Home(){
        return "home";
    }
}
