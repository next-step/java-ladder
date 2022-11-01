package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLadderFactory extends LadderFactory {

    private static final Random RANDOM = new Random();

    @Override
    Ladder creatLadder(int height, int countPerson) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(createLine(countPerson));
        }

        return new Ladder(lines);
    }

    private Line createLine(int countPerson) {
        List<Boolean> points = new ArrayList<>();

        IntStream.range(0, countPerson - 1)
                .forEach(i -> points.add(addPoint(i, points)));

        return new Line(points);
    }

    boolean addPoint(int point, List<Boolean> points) {
        if (point > 0 && points.get(point - 1)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
