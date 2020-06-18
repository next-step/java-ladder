package nextstep.step2;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> oneLayerLadder = new ArrayList<>();
    public Line(int size) {
        for (int i = 0; i < size; i++) {
            oneLayerLadder.add(true);
        }
    }

    public List<Boolean> getOneLayerLadder() {
        return this.oneLayerLadder;
    }
}
