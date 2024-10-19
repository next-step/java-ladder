package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final PositiveNumber width;
    private final PositiveNumber height;
    private final List<LadderRow> map;

    public Ladder(PositiveNumber width, PositiveNumber height) {
        this.width = width;
        this.height = height;
        map = new ArrayList<>();
        makeMap(width, height);
    }

    private void makeMap(PositiveNumber width, PositiveNumber height) {
        for (int i = 0; i < height.getValue(); i++) {
            map.add(new LadderRow(width, new RandomBarGeneratorStrategy()));
        }
    }

    public List<LadderRow> getMap() {
        return Collections.unmodifiableList(map);
    }
}
