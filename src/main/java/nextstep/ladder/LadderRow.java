package nextstep.ladder;

import java.util.Objects;
import nextstep.ladder.drawPolicy.DrawablePolicy;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private List<Point> points;
    private final DrawablePolicy randomDraw;
    private final int PERSON_COUNT;

    public LadderRow(int personCount, DrawablePolicy randomDraw) {
        this.randomDraw = randomDraw;
        this.PERSON_COUNT = personCount;

        if (personCount == 0) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람은 0명이 될 수 없습니다.");
        }

        points = new ArrayList<>();
        Point currentPoint = Point.createInstance(randomDraw);
        points.add(currentPoint);

        for (int i = 1; i < personCount; i++) {
            currentPoint = createPoint(i, currentPoint);
            points.add(currentPoint);
        }
    }

    private Point createPoint(int i, Point currentPoint) {
        if (i == PERSON_COUNT - 1) {
            return Point.lastInstance(currentPoint);
        }
        return Point.createInstance(currentPoint, randomDraw);
    }

    public String drawLadderRow(String column, String row) {
        StringBuilder stringBuilder = new StringBuilder();
        points.stream()
                .map(t -> drawLadderRowStem(t, row))
                .forEach(t -> {
                    stringBuilder.append(column);
                    stringBuilder.append(t);
                });
        return stringBuilder.toString();
    }

    private String drawLadderRowStem(Point point, String row) {
        if (point.isRightConnected()) {
            return row.repeat(PERSON_COUNT);
        }
        return " ".repeat(PERSON_COUNT);
    }
}
