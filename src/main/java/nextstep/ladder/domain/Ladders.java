package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.RandomBooleanStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private List<Ladder> ladders = new ArrayList<>();

    public Ladders(int peopleCount, int heightCount) {
        validate(heightCount);
        for (int i = 0; i < heightCount; i++) {
            ladders.add(new Ladder(peopleCount - 1, new RandomBooleanStrategy()));
        }
    }

    private void validate(int heightCount) {
        if (heightCount < 1) {
            throw new IllegalArgumentException("높이는 0이상이여야 합니다");
        }
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
