package com.bulentyilmaz.workmanagement.workmanagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeesController {
    @RequestMapping(value = "/employeesLogin")
    public String getEmplogin(){
        return "employeesLogin";
    }
}
