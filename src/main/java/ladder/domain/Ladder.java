package ladder.domain;

import ladder.service.RandomBoolean;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Layer> ladder;


    public Ladder(int line, int height, RandomBoolean randomTrueBoolean) {
        this(new ArrayList<>());
    }

    public Ladder(List<Layer> layers) {
        this.ladder = layers;
    }


}
