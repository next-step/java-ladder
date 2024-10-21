package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
            map.add(new LadderRow(width, RandomBarGeneratorStrategy.getInstance()));
        }
    }

    public List<LadderRow> getMap() {
        return Collections.unmodifiableList(map);
    }

    public List<String> getMapAsString() {
        return map.stream()
                .map(LadderRow::getRowAsString)
                .collect(Collectors.toList());
    }
}
