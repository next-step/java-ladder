package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder implements Iterable<HorizontalLine> {
    private List<HorizontalLine> ladder;

    public static Ladder valueOf(LadderSize ladderSize,
                                 LineSelector lineSelector,
                                 RightDirection rightDirection) {
        Ladder ladder = new Ladder(generateHorizontalLines(ladderSize));
        ladder.assignVertical(lineSelector);
        ladder.assignHorizontal(rightDirection);
        return ladder;
    }

    private static List<HorizontalLine> generateHorizontalLines(
            LadderSize ladderSize) {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for(int i = 0, size = ladderSize.getHeight(); i < size; i++ ) {
            horizontalLines.add(new HorizontalLine(ladderSize.getWidth()));
        }

        return horizontalLines;
    }

    private Ladder(List<HorizontalLine> horizontalLines) {
        this.ladder = new ArrayList<>(horizontalLines);
    }

    private void assignVertical(LineSelector lineSelector) {
        int width = ladder.get(0).size();
        int beforeSelectedIndex = -1;
        for (int i = 0; i < width; i++) {
            beforeSelectedIndex = assignVertical(i, beforeSelectedIndex,
                    lineSelector);
        }
    }

    private int assignVertical(int index,
                               int beforeSelectedIndex,
                               LineSelector lineSelector) {
        int height = ladder.size();
        int selectedIndex = lineSelector.select(height);
        if (beforeSelectedIndex == selectedIndex) {
            selectedIndex = (selectedIndex + 1) % height;
        }
        HorizontalLine horizontalLine = ladder.get(selectedIndex);
        horizontalLine.makeDirection(index);
        return selectedIndex;
    }

    private void assignHorizontal(RightDirection rightDirection) {
        for (HorizontalLine horizontalLine : ladder) {
            assignHorizontal(horizontalLine, rightDirection);
        }
    }

    private void assignHorizontal(HorizontalLine horizontalLine,
                                  RightDirection rightDirection) {
        for (int i = 0; i < horizontalLine.size(); i++) {
            boolean isAbleToRight = rightDirection.isAbleToRight();
            horizontalLine.makeDirectionTo(i, isAbleToRight);
        }
    }



    public List<Point> vertical(int index) {
        return ladder.stream()
                .map(horizontalLine -> horizontalLine.getPoint(index))
                .collect(Collectors.toList());
    }

    public HorizontalLine horizontal(int index) {
        return ladder.get(index);
    }

    public int height() {
        return ladder.size();
    }

    public int result(int index) {
        int nextIndex = index;
        for (HorizontalLine horizontalLine : ladder) {
            nextIndex = horizontalLine.nextIndex(nextIndex);
        }

        return nextIndex;
    }
}
