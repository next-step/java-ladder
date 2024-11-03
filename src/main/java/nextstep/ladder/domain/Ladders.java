package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BooleanStrategy;
import nextstep.ladder.domain.strategy.RandomBooleanStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private List<Ladder> ladders = new ArrayList<>();

    public Ladders(int peopleCount, int heightCount) {
        this(peopleCount, heightCount, new RandomBooleanStrategy());
    }

    public Ladders(int peopleCount, int heightCount, BooleanStrategy booleanStrategy) {
        validate(heightCount);
        for (int i = 0; i < heightCount; i++) {
            ladders.add(new Ladder(peopleCount - 1, booleanStrategy));
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

    public int searchIndex(int index) {
        for (int i = 0; i < ladders.size(); i++) {
            index = ladders.get(i).decide(index);
        }
        return index;
    }
}
