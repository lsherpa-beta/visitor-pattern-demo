package com.sherpa.visitorpatterndemo.model;

import com.sherpa.visitorpatterndemo.Visitor;

public class Engine {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Engine {}";
    }
}
