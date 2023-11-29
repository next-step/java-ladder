package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson, Random random) {
        this.points = new ArrayList<>();
        this.points.add(random.nextBoolean());
        IntStream.range(0, countOfPerson - 2)
            .forEach(index -> initPoint(index, random.nextBoolean()));
        validateLine(countOfPerson);
    }

    private void validateLine(int countOfPerson) {
        IntStream.range(0, countOfPerson - 2)
            .filter(index -> points.get(index) && points.get(index + 1))
            .forEach(point -> {
                throw new IllegalArgumentException("사다리 라인이 겹칩니다");
            });
    }

    private void initPoint(int index, boolean nextBoolean) {
        if (this.points.get(index) && nextBoolean || this.points.get(index) && !nextBoolean
            || !this.points.get(index) && !nextBoolean) {
            this.points.add(false);
            return;
        }
        if (!this.points.get(index) && nextBoolean) {
            this.points.add(true);
        }
    }

    public List<Boolean> getPoints() {
        return this.points;
    }
}
