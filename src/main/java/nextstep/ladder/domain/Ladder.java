package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder implements Iterable<HorizontalLine> {
    private List<HorizontalLine> ladder;

    public static Ladder valueOf(LadderSize ladderSize,
                                 LineSelector lineSelector,
                                 RightDirection rightDirection) {
        Ladder ladder = new Ladder(generateHorizontalLines(ladderSize));
        ladder.assignOneLineToEachVerticalLines(ladderSize.getWidth(),
                lineSelector);
        ladder.assignLinesToEachHorizontalLines(rightDirection);
        return ladder;
    }

    private static List<HorizontalLine> generateHorizontalLines(
            LadderSize ladderSize) {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for (int i = 0, size = ladderSize.getHeight(); i < size; i++) {
            horizontalLines.add(new HorizontalLine(ladderSize.getWidth()));
        }

        return horizontalLines;
    }

    private Ladder(List<HorizontalLine> horizontalLines) {
        this.ladder = new ArrayList<>(horizontalLines);
    }

    private void assignOneLineToEachVerticalLines(int width,
                                                  LineSelector lineSelector) {
        int beforeSelectedIndex = -1;
        for (int i = 0; i < width; i++) {
            beforeSelectedIndex =
                    assignOneLineToVerticalLine(i, beforeSelectedIndex,
                            lineSelector);
        }
    }

    private int assignOneLineToVerticalLine(int index,
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

    private void assignLinesToEachHorizontalLines(
            RightDirection rightDirection) {
        for (HorizontalLine horizontalLine : ladder) {
            assignLinesToHorizontalLine(horizontalLine, rightDirection);
        }
    }

    private void assignLinesToHorizontalLine(HorizontalLine horizontalLine,
                                             RightDirection rightDirection) {
        for (int i = 0; i < horizontalLine.size(); i++) {
            boolean isAbleToRight = rightDirection.isAbleToRight();
            horizontalLine.makeDirectionTo(i, isAbleToRight);
        }
    }

    public List<Point> getVerticalLine(int index) {
        return ladder.stream()
                .map(horizontalLine -> horizontalLine.getPoint(index))
                .collect(Collectors.toList());
    }

    public HorizontalLine getHorizontalLine(int index) {
        return ladder.get(index);
    }

    public int height() {
        return ladder.size();
    }

    public int result(int index) {
        int nextIndex = index;
        for (HorizontalLine horizontalLine : ladder) {
            nextIndex = horizontalLine.getNextIndex(nextIndex);
        }

        return nextIndex;
    }

    @Override
    public Iterator<HorizontalLine> iterator() {
        return ladder.iterator();
    }
}
