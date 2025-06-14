package com.sherpa.visitorpatterndemo.model;

import com.sherpa.visitorpatterndemo.Visitor;

public class Engine {
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Engine {}";
    }
}
