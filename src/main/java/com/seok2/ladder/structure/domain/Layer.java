package com.seok2.ladder.structure.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Layer {

    protected final List<Line> layer;

    private Layer(List<Line> layer) {
        this.layer = layer;
    }

    public static Layer bottom(int width) {
        return IntStream.range(0, width)
            .mapToObj(idx -> Line.of())
            .collect(collectingAndThen(toList(), Layer::new));
    }

    public Layer build() {
        LinkedList<Line> deque = new LinkedList<>();
        layer.forEach(line -> deque.add(line.build(deque.peekLast(), new RandomBuildStategy())));
        return new Layer(new ArrayList<>(deque));
    }

}
