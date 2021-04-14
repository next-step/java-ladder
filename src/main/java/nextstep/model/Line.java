package nextstep.model;

import static nextstep.constant.Constant.*;

public class Line {
    private final Points points;

    public Line (int countOfPerson) {
        this.points = new Points(countOfPerson);
    }

    public void mark(int target) {
        points.markOne(target, true);
    }

    public void initMark() {
        for (int i = 0; i < points.size(); i++) {
            points.markOne(i, RAND.nextBoolean());
        }
    }

    public void mark() {
        for (int i = 0; i < points.size(); i++) {
            points.markOne(i, RAND.nextBoolean());
        }
    }

    private void markOneRandom() {
        points.markOne((RAND.nextInt(points.size())), true);
    }

    public void reMark(Line top) {
    }

    public Points getPoints() {
        return this.points;
    }

    public String lineString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < points.size(); i++) {
            stringBuilder.append("|");
            if (points.get(i)) {
                stringBuilder.append(HORIZON_LADDER_STRING);
            } else {
                stringBuilder.append(EMPTY_LADDER_STRING);
            }
            if (i == points.size() - 1) {
                stringBuilder.append("|");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
