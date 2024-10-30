package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.RandomBoolean;

import java.util.ArrayList;
import java.util.List;

public class Heights {

    private List<Verticals> height = new ArrayList<>();

    public Heights(int peopleCount, int heightCount) {
        validate(heightCount);
        for (int i = 0; i < heightCount; i++) {
            height.add(new Verticals(peopleCount, new RandomBoolean()));
        }
    }

    private void validate(int heightCount) {
        if (heightCount < 1) {
            throw new IllegalArgumentException("높이는 0이상이여야 합니다");
        }
    }

    public List<Verticals> getHeight() {
        return height;
    }
}
