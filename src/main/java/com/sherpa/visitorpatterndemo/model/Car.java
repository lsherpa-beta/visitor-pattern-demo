package com.sherpa.visitorpatterndemo.model;

import com.sherpa.visitorpatterndemo.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;

public class Car implements Element {
    private Body body = new Body();
    private Engine engine = new Engine();
    private Wheel[] wheels = {new Wheel(), new Wheel(), new Wheel(), new Wheel()};

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }

    /**
     * Visits every part (body, engine, each wheel) and then the car itself,
     * combining the results with the given collector.
     */
    public <R, RR> RR accept(Visitor<R> visitor, Collector<? super R, ?, RR> collector) {
        List<R> results = new ArrayList<>();
        for (Element part : parts()) {
            results.add(part.accept(visitor));
        }
        results.add(accept(visitor));
        return results.stream().collect(collector);
    }

    private List<Element> parts() {
        List<Element> parts = new ArrayList<>();
        parts.add(body);
        parts.add(engine);
        parts.addAll(Arrays.asList(wheels));
        return parts;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = Objects.requireNonNull(body);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = Objects.requireNonNull(engine);
    }

    public Wheel[] getWheels() {
        return wheels.clone();
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = Objects.requireNonNull(wheels).clone();
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
