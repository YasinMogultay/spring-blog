package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addMethod(@PathVariable int num1, @PathVariable int num2) {
        return "Your result is " + (num1 + num2);
    }

    @RequestMapping(path = "/subtract/{a}/from/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractMethod(@PathVariable int a, @PathVariable int b) {
        return "Your result is " + (a - b);
    }

    @RequestMapping(path = "/multiply/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyMethod(@PathVariable int x, @PathVariable int y) {
        return "Your reuslt is " + (x * y);
    }

    @RequestMapping(path = "/divide/{a}/by/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String divideMethod(@PathVariable int a, @PathVariable int b) {
        return "Your result is " + (a / b);
    }

}
