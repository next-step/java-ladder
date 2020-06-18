package nextstep.step2.domain;

import nextstep.step2.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> oneLayerLadder = new ArrayList<>();

    public Line(int personOfCount) {
        setLadderLine(personOfCount);
    }

    private void setLadderLine(int personOfCount) {
        oneLayerLadder.add(0, RandomUtils.getRandomBoolean());

        for (int i = 1; i < personOfCount - 1; i++) {
            setLine(oneLayerLadder.get(i - 1));
        }

        oneLayerLadder.add(false);
    }

    public List<Boolean> getOneLayerLadder() {
        return this.oneLayerLadder;
    }

    private void setLine(Boolean isTrue) {
        if (isTrue) {
            oneLayerLadder.add(false);

            return;
        }

        oneLayerLadder.add(RandomUtils.getRandomBoolean());
    }
}
