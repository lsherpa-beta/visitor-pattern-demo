package com.sherpa.visitorpatterndemo;

import com.sherpa.visitorpatterndemo.model.Body;
import com.sherpa.visitorpatterndemo.model.Car;
import com.sherpa.visitorpatterndemo.model.Engine;
import com.sherpa.visitorpatterndemo.model.Wheel;

public interface Visitor {
    void visit(Car car);
    void visit(Body body);
    void visit(Engine engine);
    void visit(Wheel wheel);
}
