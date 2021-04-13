package nextstep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static nextstep.constant.Constant.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(false);
        }
    }

    public void mark(int target) {
        points.set(target, true);
    }

    public void initMark() {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, RAND.nextBoolean());
        }

        long trueCount = points.stream()
                .filter(s -> s == true)
                .count();

        if (trueCount == 0) {
            markOneRandom();
        }

        long falseCount = points.stream()
                .filter(s -> s == false)
                .count();
        if (falseCount == 0) {
            this.initMark();
        }
    }

    public void mark() {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, RAND.nextBoolean());
        }
        long trueCount = points.stream()
                .filter(s -> s == true)
                .count();

        if (trueCount == 0) {
            markOneRandom();
        }

        long falseCount = points.stream()
                .filter(s -> s == false)
                .count();
        if (falseCount == 0) {
            throw new IllegalArgumentException("Have to redraw");
        }
    }

    private void markOneRandom() {
        points.set((RAND.nextInt(points.size())), true);
    }

    public void reMark(Line top) {
        int first = IntStream.range(0, top.points.size())
                .filter(i -> top.points.get(i))
                .findFirst()
                .orElse(0);
        if (first == 0) {
            this.points.set(first + 1, true);
            this.points.stream()
                    .skip(first + 1)
                    .forEach(p -> p = false);
        }
        if (first == this.points.size()) {
            this.points.set(first - 1, true);
            this.points.stream()
                    .skip(first - 1)
                    .forEach(p -> p = false);
        }
    }

    public List<Boolean> getPoints() {
        return points;
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
