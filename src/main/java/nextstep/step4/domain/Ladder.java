package nextstep.step4.domain;

import java.util.*;

public class Ladder {
    private final List<Line> lines;
    private final UserData userData;

    public Ladder(final UserData userData, final List<Line> lines) {
        this.userData = userData;
        this.lines = lines;
    }

    public Ladder(final UserData userData, final LadderHeight ladderHeight) {
        this.userData = userData;

        int pointsSize = userData.size();
        this.lines = createLines(pointsSize, ladderHeight);
    }

    private List<Line> createLines(final int pointsSize, final LadderHeight ladderHeight) {
        List<Line> tempLines = new ArrayList<>();

        for (int i = 0; i < ladderHeight.value(); i++) {
            tempLines.add(buildLine(pointsSize));
        }

        return tempLines;
    }

    private Line buildLine(final int pointsSize) {
        List<Point> points = new ArrayList<>();

        Point point = buildFirstPoint();
        points.add(point);

        for (int i = 1; i < pointsSize - 1; i++) {
            point = buildNextPoint(point);
            points.add(point);
        }

        points.add(buildLastPoint(point));

        return new Line(points);
    }

    private Point buildFirstPoint() {
        return Point.first(new Random().nextBoolean());
    }

    private Point buildNextPoint(Point point) {
        return point.next(new Random().nextBoolean());
    }

    private Point buildLastPoint(final Point point) {
        return point.last();
    }

    public UserInputTexts userNames() {
        return this.userData.getUserNames();
    }

    public UserInputTexts userResults() {
        return this.userData.getUserResults();
    }

    public List<Line> body() {
        return this.lines;
    }

    public LadderResult run() {
        Map<String, String> ladderResult = new LinkedHashMap<>();

        for (int userIdx = 0; userIdx < userNames().size(); userIdx++) {
            final int arrivalIdx = move(userIdx);

            ladderResult.put(userNames().get(userIdx), userResults().get(arrivalIdx));
        }

        return new LadderResult(ladderResult);
    }

    private int move(final int userIdx) {
        int arrivalIdx = userIdx;

        for (final Line line : this.lines) {
            arrivalIdx = line.move(arrivalIdx);
        }

        return arrivalIdx;
    }
}
