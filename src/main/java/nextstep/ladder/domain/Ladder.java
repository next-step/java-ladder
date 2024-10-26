package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final PositiveNumber height;
    private final List<LadderRow> map;

    public Ladder(PositiveNumber width, PositiveNumber height) {
        this.height = height;
        this.map = new ArrayList<>();
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

    public String getLadderAsString() {
        List<String> mapAsString = getMapAsString();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.size(); i++) {
            builder.append(mapAsString.get(i));
            if (i != mapAsString.size() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    private List<String> getMapAsString() {
        return map.stream()
                .map(LadderRow::getRowAsString)
                .collect(Collectors.toList());
    }

    public int getLadderResultIndex(int startIndex) {
        return IntStream.range(0, height.getValue())
                .reduce(startIndex, this::getNextIndex);
    }

    private int getNextIndex(int currentIndex, int rowIndex) {
        LadderRow currentStep = map.get(rowIndex);
        if (currentStep.isLeftMoveable(currentIndex)) {
            return currentIndex - 1;
        }
        if (currentStep.isRightMoveable(currentIndex)) {
            return currentIndex + 1;
        }
        return currentIndex;
    }
}
