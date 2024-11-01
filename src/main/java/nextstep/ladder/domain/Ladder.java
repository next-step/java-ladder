package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.RandomBooleanStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Lines> ladder = new ArrayList<>();

    public Ladder(int peopleCount, int heightCount) {
        validate(heightCount);
        for (int i = 0; i < heightCount; i++) {
            ladder.add(new Lines(peopleCount - 1, new RandomBooleanStrategy()));
        }
    }

    private void validate(int heightCount) {
        if (heightCount < 1) {
            throw new IllegalArgumentException("높이는 0이상이여야 합니다");
        }
    }

    public List<Lines> getHeight() {
        return ladder;
    }
}
