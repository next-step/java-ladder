package com.seok2.ladder.structure.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Layer {

    private final List<Pillar> layer;

    private Layer(List<Pillar> layer) {
        this.layer = layer;
    }

    public static Layer bottom(int width) {
        return IntStream.range(0, width)
            .mapToObj(idx -> Pillar.of())
            .collect(collectingAndThen(toList(), Layer::new));
    }

    public Layer build(BuildStrategy strategy) {
        LinkedList<Pillar> deque = new LinkedList<>();
        layer.forEach(pillar -> deque.add(pillar.build(deque.peekLast(), strategy)));
        return new Layer(new ArrayList<>(deque));
    }

    public Pillar get(int idx) {
        return layer.get(idx);
    }

    public List<Pillar> getLayer() {
        return layer;
    }
}
