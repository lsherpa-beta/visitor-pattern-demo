package com.sherpa.visitorpatterndemo;

import com.sherpa.visitorpatterndemo.model.Body;
import com.sherpa.visitorpatterndemo.model.Car;
import com.sherpa.visitorpatterndemo.model.Engine;
import com.sherpa.visitorpatterndemo.model.Wheel;

/**
 * A second operation on the same model: prices each part.
 * Added without touching any model class.
 */
public class PriceVisitor implements Visitor<Integer> {

    public static final int CAR_ASSEMBLY = 1_000;
    public static final int BODY = 5_000;
    public static final int ENGINE = 8_000;
    public static final int WHEEL = 250;

    @Override
    public Integer visit(Car car) {
        return CAR_ASSEMBLY;
    }

    @Override
    public Integer visit(Body body) {
        return BODY;
    }

    @Override
    public Integer visit(Engine engine) {
        return ENGINE;
    }

    @Override
    public Integer visit(Wheel wheel) {
        return WHEEL;
    }
}
