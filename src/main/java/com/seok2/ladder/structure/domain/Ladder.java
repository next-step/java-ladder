package com.seok2.ladder.structure.domain;

import java.util.Deque;
import java.util.LinkedList;

public class Ladder {

    private final Deque<Layer> ladder;

    private Ladder(Deque<Layer> layers) {
        this.ladder = layers;
    }

    public static Ladder of(Height height, int width) {
        Deque<Layer> deque = new LinkedList<>();
        deque.push(Layer.bottom(width));
        for (int i = 0; i < height.intValue(); i++) {
            deque.push(deque.peek().build(new RandomBuildStategy()));
        }
        return new Ladder(deque);
    }

    public Layer getBottom() {
        return ladder.getLast();
    }

    public Layer getTop() {
        return ladder.getFirst();
    }

    public Deque<Layer> getLadder() {
        return ladder;
    }
}
