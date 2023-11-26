package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.horizontallinecreationstrategy.HorizontalLineStrategy;

public class LadderGame {

    private final HorizontalLineStrategy horizontalLineStrategy;
    private final Members members;

    public LadderGame(HorizontalLineStrategy horizontalLineStrategy, String[] memberNames) {
        this.horizontalLineStrategy = horizontalLineStrategy;
        this.members = joinMembers(memberNames);
    }

    public Members members() {
        return members;
    }

    public Ladder generateLadder(int heightOfLadder) {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            horizontalLines.add(new HorizontalLine(determineHorizontalLineAtPoint()));
        }
        return new Ladder(horizontalLines);
    }

    private Members joinMembers(String[] memberNames) {
        return new Members(Arrays.stream(memberNames)
            .map(Member::new)
            .collect(Collectors.toList()));
    }

    private List<Point> determineHorizontalLineAtPoint() {
        LinkedList<Point> points = new LinkedList<>();
        for (int i = 0; i < members.countOfMembers() - 1; i++) {
            addHorizontalLineRandomlyOrSkip(points);
        }
        return points;
    }

    private void addHorizontalLineRandomlyOrSkip(LinkedList<Point> points) {
        if (points.isEmpty()) {
            points.addLast(new Point(horizontalLineStrategy.isAbleToGenerate()));
            return;
        }
        if (points.getLast().isTrue()) {
            points.addLast(new Point(false));
            return;
        }
        if (points.getLast().isFalse()) {
            points.addLast(new Point(horizontalLineStrategy.isAbleToGenerate()));
        }
    }
}
