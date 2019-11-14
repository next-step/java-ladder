package com.seok2.ladder.structure.domain;

import java.util.Deque;
import java.util.LinkedList;

public class Ladder {


    protected final Deque<Layer> layers;

    private Ladder(Deque<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder of(Height height, int width) {
        Deque<Layer> deque = new LinkedList<>();
        deque.push(Layer.bottom(width));
        for (int i = 0; i < height.intValue(); i++) {
            deque.push(deque.peek().build(new RandomBuildStategy()));
        }
        deque.pollLast();
        return new Ladder(deque);
    }

    public Layer getLast() {
        return layers.getLast();
    }

    public Layer getFirst() {
        return layers.getFirst();
    }

}
