package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Line {
    private final List<Boolean> points;
    private boolean lineAppearLeft = false;

    public Line(int countOfPerson) {
        points = generateLine(countOfPerson);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int getWidth() {
        return points.size();
    }

    private List<Boolean> generateLine(int countOfPerson) {
        List<Boolean> line = Stream
                .generate(() -> randomGenerateBlock())
                .limit(countOfPerson)
                .collect(toList());

        if (isEmptyLine(line)) {
            line = generateLine(countOfPerson);
        }

        return line;
    }

    private boolean isEmptyLine(List<Boolean> line) {
        return line.stream()
                .limit(line.size() - 1)
                .allMatch(point -> !point);
    }

    private boolean randomGenerateBlock() {
        Random random = new Random();
        boolean line = lineAppearLeft ? false : random.nextBoolean();
        lineAppearLeft = false;
        if (line) {
            lineAppearLeft = true;
        }
        return line;
    }
}
