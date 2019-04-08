package com.bulentyilmaz.workmanagement.workmanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmanManagerController {
    @RequestMapping(value = "/departmanManagerLogin")
    public String getDMlogin(){
        return "departmanManagerLogin";
    }
}
