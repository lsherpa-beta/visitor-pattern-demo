package com.sherpa.visitorpatterndemo.model;

import com.sherpa.visitorpatterndemo.Visitor;

import java.util.Arrays;

public class Car {
   private Body body = new Body();
   private Engine engine = new Engine();
   private Wheel[] wheels = {new Wheel(), new Wheel(), new Wheel(),new Wheel()};

   public void accept(Visitor visitor){
       this.body.accept(visitor);
       this.engine.accept(visitor);
       Arrays.stream(this.wheels).forEach(wheel -> wheel.accept(visitor));
       visitor.visit(this);
   }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body +
                ", engine=" + engine +
                ", wheels=" + Arrays.toString(wheels) +
                '}';
    }
}
