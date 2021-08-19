package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    private Line(int countOfPerson) {
        Random random = new Random();
        points = IntStream.range(0, countOfPerson)
            .mapToObj(point -> random.nextBoolean())
            .collect(Collectors.toList());
        commonInit();
    }

    private Line(List<Boolean> points) {
        this.points = points;
        commonInit();
    }

    private void commonInit() {
        points.set(points.size() - 1, false);
        checkCorrectLadderAndFix();
    }

    private boolean isTrueEqualToPrevious(int currentIndex) {
        if (currentIndex < 1) {
            return false;
        }

        if (points.get(currentIndex - 1) == points.get(currentIndex)) {
            return true;
        }

        return false;
    }

    private void checkCorrectLadderAndFix() {
        if (checkNoneTrueAndChange(points.contains(true))) {
            return;
        }
        checkContinuousTrueAndChange();
    }

    private void checkContinuousTrueAndChange() {
        Random random = new Random();
        IntStream.range(0, points.size() - 1)
            .filter(this::isTrueEqualToPrevious)
            .forEach(index -> points.set(index - random.nextInt(2), false));
    }

    private boolean checkNoneTrueAndChange(boolean containsTrue) {
        if (!containsTrue) {
            Random random = new Random();
            points.set(random.nextInt(points.size() - 1), true);
            return true;
        }
        return false;
    }

    public static Line from(int countOfPerson) {
        return new Line(countOfPerson);
    }

    public static Line from(List<Boolean> points) {
        return new Line(points);
    }

    public List<Boolean> toList() {
        return points;
    }
}
