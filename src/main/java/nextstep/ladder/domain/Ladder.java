package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<HorizontalLine> ladder;
    private RightDirection rightDirection;
    private LineSelector lineSelector;

    public Ladder(LadderSize ladderSize, RightDirection rightDirection,
                  LineSelector lineSelector) {
        this.rightDirection = rightDirection;
        this.lineSelector = lineSelector;
        initLadder(ladderSize);
    }

    private void initLadder(LadderSize ladderSize) {
        ladder = IntStream.range(0, ladderSize.getHeight())
                .mapToObj(i -> new HorizontalLine(ladderSize.getWidth(),
                        rightDirection))
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

    public List<HorizontalLine> getLadder() {
        return new ArrayList<>(ladder);
    }
}
