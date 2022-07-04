package com.example._2_3.controller;

import com.example._2_3.service.CalculatorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String greetings(){
        return "<h1>Вэлком в калькулятор </h1>";
    }
    @GetMapping("/plue")
    public String plue (@RequestParam(value = "num1", required = false) Integer a ,
                        @RequestParam(value = "num2", required = false) Integer b){
        if (Objects.isNull(a)|| Objects.isNull(b)){
            return "точно все передано?";
        }
        return buildResult(a,b,calculatorService. plus (a,b), "+");
    }
    @GetMapping("/minus")
    public String minus (@RequestParam(value = "num1", required = false) Integer a ,
                         @RequestParam(value = "num2", required = false) Integer b){
        if (Objects.isNull(a)|| Objects.isNull(b)){
            return "точно все передано?";
        }
        return buildResult(a,b,calculatorService. minus  (a,b), "-");
    }
    @GetMapping("/minus")
    public String multiply (@RequestParam(value = "num1", required = false) Integer a ,
                            @RequestParam(value = "num2", required = false) Integer b){
        if (Objects.isNull(a)|| Objects.isNull(b)){
            return "точно все передано?";
        }
        return buildResult(a,b,calculatorService.multiply  (a,b), "*");
    }
    @GetMapping("/divide ")
    public String divide (@RequestParam(value = "num1", required = false) Integer a ,
                          @RequestParam(value = "num2", required = false) Integer b){
        if (Objects.isNull(a)|| Objects.isNull(b)){
            return "точно все передано?";
        }
        if (b==0) {
            return "на ноль делить нельзя";
        }
        return buildResult(a,b,calculatorService.divide  (a,b), ":");
    }
    public String buildResult(Integer a ,Integer b , Number result,  String operation){
        return a + " " + operation + " "+ b + " = "+ result ;
    }

}

