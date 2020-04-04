package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<HorizontalLine> ladder;
    private LineSelector lineSelector;
    private RightDirection rightDirection;

    public Ladder(List<HorizontalLine> horizontalLines,
                  LineSelector lineSelector,
                  RightDirection rightDirection) {
        this.ladder = new ArrayList<>(horizontalLines);
        this.lineSelector = lineSelector;
        this.rightDirection = rightDirection;
        assignLine();
    }

    private void assignLine() {
        assignVertical();
        assignHorizontal();

    }

    private void assignVertical() {
        int width = ladder.get(0).size();
        for (int i = 0; i < width; i++) {
            assignVertical(i);
        }
    }

    private void assignVertical(int index) {
        boolean hasRightDirection = vertical(index).stream()
                .anyMatch(Point::hasRightDirection);
        if (hasRightDirection) {
            return;
        }
        int selectedIndex = lineSelector.select(ladder.size());
        HorizontalLine horizontalLine = ladder.get(selectedIndex);
        horizontalLine.reverse(index);
    }

    private void assignHorizontal() {
        for(HorizontalLine horizontalLine: ladder) {
            // todo
            for(int i = 0; i < horizontalLine.size(); i++) {
                boolean isAbleToRight = rightDirection.isAbleToRight();
                if(isAbleToRight) {
                    horizontalLine.makePointToTrue(i);
                    break;
                }
            }
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
