package com.luv2code.springdemo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

//Declared a controller Class
@Controller
public class HelloWorldController {

    //Controller method to SHOW the initial HTML Form
    @RequestMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }

    //Controller to PROCESS the HTML Form
    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model) {

        String studentName = request.getParameter("studentName");
        studentName = studentName.toUpperCase();

        String UpdatedData = "Hello, " + studentName;

        model.addAttribute("name", UpdatedData);

        return "helloworld";
    }

    @RequestMapping("/processFormWithRequestParams")
    public String processFormWithRequestParams(@RequestParam("studentName") String theName, Model model) {
        model.addAttribute("name", ("Requst Param Used: " + theName.toUpperCase()));
        return "helloworld";
    }

}