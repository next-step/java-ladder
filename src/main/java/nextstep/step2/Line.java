package nextstep.step2;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> oneLayerLadder = new ArrayList<>();

    public Line(int size) {
        oneLayerLadder.add(0, RandomUtils.getRandomBoolean());
        for (int i = 1; i < size - 1; i++) {
            Boolean beforeLine = oneLayerLadder.get(i - 1);
            if (beforeLine) {
                oneLayerLadder.add(false);
            } else {
                oneLayerLadder.add(RandomUtils.getRandomBoolean());
            }
        }
        oneLayerLadder.add(false);
    }

    public List<Boolean> getOneLayerLadder() {
        return this.oneLayerLadder;
    }
}
