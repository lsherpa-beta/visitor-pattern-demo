package com.sherpa.visitorpatterndemo.model;

import com.sherpa.visitorpatterndemo.Visitor;

public class Body {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Body{}";
    }
}
