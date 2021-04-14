package nextstep.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Points {
    private final List<Boolean> points;

    public Points(int countOfPerson) {
        this.points = new ArrayList<>();
        IntStream.range(0, countOfPerson)
                .forEach(num -> points.add(false));
    }

    public Points(List<Boolean> points) {
        this.points = points;
    }

    public int size() {
        return this.points.size();
    }

    public void markOne(int target, boolean bool) {
        points.set(target, bool);
    }

    public void markRandom() {
        for (int i = 0; i < this.points.size(); i++) {
            Random random = new Random();
            this.points.set(i, random.nextBoolean());
        }
        long count = this.points.stream()
                .filter(p -> p)
                .count();
        if (count == 0) {
            this.markRandom();
        }
    }

    public boolean get(int i) {
        return this.points.get(i);
    }

    public void markBottom(Points top) {
        for (int i = 0; i < top.size(); i++) {
            if (top.get(i)) {
                Random random = new Random();
                boolean nextBoolean = random.nextBoolean();
                int target = nextBoolean ? i - 1 : i + 1;
                if (target < 0 || target >= top.size()) {
                    nextBoolean = !nextBoolean;
                    target = nextBoolean ? i - 1 : i + 1;
                }
                if (target < 0 || target >= top.size()) {
                    continue;
                }
                if (!top.get(target)) {
                    this.points.set(target, true);
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points1 = (Points) o;
        return Objects.equals(points, points1.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Points{" +
                "points=" + points +
                '}';
    }
}
