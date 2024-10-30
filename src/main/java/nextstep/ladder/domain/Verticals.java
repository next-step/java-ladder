package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BooleanStrategy;

import java.util.ArrayList;
import java.util.List;

public class Verticals {
    private final List<Boolean> vertical = new ArrayList<>();

    public Verticals(int countOfPerson, BooleanStrategy booleanStrategy) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            vertical.add(createLine(i, booleanStrategy));
        }
    }

    private Boolean createLine(int i, BooleanStrategy booleanStrategy) {
        return isPrev(i) ? false : booleanStrategy.decide();
    }

    private boolean isPrev(int i) {
        return i == 0 ? false : vertical.get(i - 1);
    }

    public List<Boolean> getVertical() {
        return vertical;
    }
}
