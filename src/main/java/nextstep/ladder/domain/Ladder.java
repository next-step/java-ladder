package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<HorizontalLine> ladder;

    static Ladder of(List<HorizontalLine> horizontalLines,
                     LineSelector lineSelector,
                     RightDirection rightDirection) {
        Ladder ladder = new Ladder(horizontalLines);
        ladder.assignVertical(lineSelector);
        ladder.assignHorizontal(rightDirection);
        return ladder;
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
        horizontalLine.makePointToTrue(index);
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
            horizontalLine.makePointTo(i, isAbleToRight);
        }
    }


    public int height() {
        return ladder.size();
    }

    public List<Point> vertical(int index) {
        return ladder.stream()
                .map(horizontalLine -> horizontalLine.getPoint(index))
                .collect(Collectors.toList());
    }

    public HorizontalLine horizontal(int index) {
        return ladder.get(index);
    }

    public List<HorizontalLine> getLadder() {
        return new ArrayList<>(ladder);
    }

    public int size() {
        return ladder.size();
    }
}
