package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final int SECOND_POINT_INDEX = 1;
    private static final int INDEX_LEFT_SIDE = -1;
    private static final int INDEX_RIGHT_SIDE = 1;

    private final List<BarType> barTypes = new ArrayList<>();

    public Line(int personCount, BarCreator barCreator) {

        addFirstPoint();

        for (int i = SECOND_POINT_INDEX; i < personCount; i++) {
            barTypes.add(getCurrentPoint(getLeftPoint(i), barCreator));
        }
    }

    private void addFirstPoint() {
        barTypes.add(BarType.NONE);
    }

    private BarType getLeftPoint(int index) {
        return barTypes.get(index + INDEX_LEFT_SIDE);
    }

    private BarType getCurrentPoint(BarType barType, BarCreator barCreator) {
        if (barType == BarType.LEFT) {
            return BarType.NONE;
        }
        return BarType.of(barCreator.create());
    }

    public List<String> getBarTypes() {
        return barTypes.stream()
                       .map(BarType::getBar)
                       .collect(Collectors.toList());
    }

    private boolean hasLeftBar(int index) {
        return hasBar(index);
    }

    private boolean hasRightBar(int index) {
        if (right(index) >= barTypes.size()) {
            return false;
        }
        return hasBar(right(index));
    }

    private boolean hasBar(int index) {
        return barTypes.get(index) == BarType.LEFT;
    }

    private int right(int index) {
        return index + INDEX_RIGHT_SIDE;
    }

    public int move(int currentIndex) {

        if (hasLeftBar(currentIndex)) {
            return moveLeft(currentIndex);
        }

        if (hasRightBar(currentIndex)) {
            return moveRight(currentIndex);
        }

        return currentIndex;
    }

    private int moveLeft(int currentIndex) {
        return currentIndex + INDEX_LEFT_SIDE;
    }

    private int moveRight(int currentIndex) {
        return currentIndex + INDEX_RIGHT_SIDE;
    }
}
