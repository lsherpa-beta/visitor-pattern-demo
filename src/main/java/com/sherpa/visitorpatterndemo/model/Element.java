package com.sherpa.visitorpatterndemo.model;

import com.sherpa.visitorpatterndemo.Visitor;

public interface Element {
    <R> R accept(Visitor<R> visitor);
}
