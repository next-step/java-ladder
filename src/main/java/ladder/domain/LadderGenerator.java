package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.horizontallinecreationstrategy.HorizontalLineStrategy;
import org.apache.commons.lang3.math.NumberUtils;

public class LadderGenerator {

    private final HorizontalLineStrategy horizontalLineStrategy;
    private final Members members;
    private final GameResults gameResults;

    public LadderGenerator(HorizontalLineStrategy horizontalLineStrategy, String[] memberNames,
        GameResults gameResults) {
        this.horizontalLineStrategy = horizontalLineStrategy;
        this.members = joinMembers(memberNames);
        this.gameResults = gameResults;
    }

    public Members members() {
        return members;
    }

    public Ladder generateLadder(String heightOfLadder) {
        validateHeightOfLadder(heightOfLadder);
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(heightOfLadder); i++) {
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

    private void validateHeightOfLadder(String heightOfLadder) {
        if (!NumberUtils.isDigits(heightOfLadder)) {
            throw new IllegalArgumentException("사다리 높이는 숫자만 입력해야합니다.");
        }
        if (Integer.parseInt(heightOfLadder) <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1이상 입력해야합니다.");
        }
    }
}
