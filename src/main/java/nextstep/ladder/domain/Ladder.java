package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    // todo 어떻게 인자수를 줄이지?
    private List<HorizontalLine> ladder;
    private RightDirection rightDirection;
    private LineSelector lineSelector;

    // todo 받아야 하는 인자가 너무 많다.
    public Ladder(int width, int height, RightDirection rightDirection,
                  LineSelector lineSelector) {
        this.rightDirection = rightDirection;
        this.lineSelector = lineSelector;
        initLadder(width, height);
    }

    private void initLadder(int width, int height) {
        ladder = IntStream.range(0, height)
                .mapToObj(i -> new HorizontalLine(width, rightDirection))
                .collect(Collectors.toList());

        adjustLadder();
    }

    private void adjustLadder() {
        int width = ladder.get(0).size();
        for (int i = 0; i < width; i++) {
            adjustLadder(i);
        }
    }

    private void adjustLadder(int index) {
        boolean hasRightDirection = vertical(index).stream()
                .anyMatch(Point::hasRightDirection);
        if (hasRightDirection) {
            return;
        }
        int selectedIndex = lineSelector.select(ladder.size());
        HorizontalLine horizontalLine = ladder.get(selectedIndex);
        horizontalLine.reverse(index);
    }

    public int height() {
        return ladder.size();
    }

    public List<Point> vertical(int index) {
        return ladder.stream()
                .map(horizontalLine -> horizontalLine.getPoint(index))
                .collect(Collectors.toList());
    }
}
