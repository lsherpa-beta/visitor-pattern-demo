package com.sherpa.visitorpatterndemo;

import com.sherpa.visitorpatterndemo.model.Body;
import com.sherpa.visitorpatterndemo.model.Car;
import com.sherpa.visitorpatterndemo.model.Engine;
import com.sherpa.visitorpatterndemo.model.Wheel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;


public class VisitorPatternDemoApplication {

    public static void main(String[] args) {

        System.out.println("Hello Visitor Pattern");
        Car toyota = new Car();
        var visitor = new Visitor<String>() {

            @Override
            public String visit(Car car) {
             return "Visited Car " + car;
            }

            @Override
            public String visit(Body body) {
               return "Visited Body " + body;
            }

            @Override
            public String visit(Engine engine) {
               return  "Visited Engine " + engine;
            }

            @Override
            public String visit(Wheel wheel) {
               return "Visited Wheel " + wheel;
            }

        };
        String visited = toyota.accept(visitor, Collectors.joining("---"));

        System.out.println("Visited = " + visited);

        List<String> accept = toyota.accept(visitor, Collectors.toList());
        accept.forEach(System.out::println);

    }

}
