package com.sherpa.visitorpatterndemo;

import com.sherpa.visitorpatterndemo.model.Body;
import com.sherpa.visitorpatterndemo.model.Car;
import com.sherpa.visitorpatterndemo.model.Engine;
import com.sherpa.visitorpatterndemo.model.Wheel;

public interface Visitor<R> {
    R visit(Car car);
    R visit(Body body);
    R visit(Engine engine);
    R visit(Wheel wheel);
}
