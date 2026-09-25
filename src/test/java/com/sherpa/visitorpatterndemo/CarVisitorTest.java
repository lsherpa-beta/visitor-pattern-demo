package com.sherpa.visitorpatterndemo;

import com.sherpa.visitorpatterndemo.model.Body;
import com.sherpa.visitorpatterndemo.model.Car;
import com.sherpa.visitorpatterndemo.model.Engine;
import com.sherpa.visitorpatterndemo.model.Wheel;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarVisitorTest {

    private final Visitor<String> typeName = new Visitor<>() {

        @Override
        public String visit(Car car) {
            return "Car";
        }

        @Override
        public String visit(Body body) {
            return "Body";
        }

        @Override
        public String visit(Engine engine) {
            return "Engine";
        }

        @Override
        public String visit(Wheel wheel) {
            return "Wheel";
        }
    };

    @Test
    void visitsPartsInOrderThenCar() {
        List<String> visited = new Car().accept(typeName, Collectors.toList());

        assertEquals(List.of("Body", "Engine", "Wheel", "Wheel", "Wheel", "Wheel", "Car"), visited);
    }

    @Test
    void visitsEveryWheelRegardlessOfCount() {
        Car car = new Car();
        car.setWheels(new Wheel[]{new Wheel(), new Wheel(), new Wheel()});

        List<String> visited = car.accept(typeName, Collectors.toList());

        assertEquals(List.of("Body", "Engine", "Wheel", "Wheel", "Wheel", "Car"), visited);
    }

    @Test
    void priceVisitorSumsAllParts() {
        int total = new Car().accept(new PriceVisitor(), Collectors.summingInt(Integer::intValue));

        int expected = PriceVisitor.BODY + PriceVisitor.ENGINE
                + 4 * PriceVisitor.WHEEL + PriceVisitor.CAR_ASSEMBLY;
        assertEquals(expected, total);
    }

    @Test
    void wheelsAreDefensivelyCopied() {
        Car car = new Car();
        car.getWheels()[0] = null;

        List<String> visited = car.accept(typeName, Collectors.toList());

        assertEquals(4, visited.stream().filter("Wheel"::equals).count());
    }

    @Test
    void rejectsNullParts() {
        Car car = new Car();

        assertThrows(NullPointerException.class, () -> car.setBody(null));
        assertThrows(NullPointerException.class, () -> car.setWheels(null));
    }
}
