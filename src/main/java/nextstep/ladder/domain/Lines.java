package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lines {
    private static final Random RANDOM = new Random();

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public static Lines of(int numberOfPlayers, int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> getBuildWithRandomPoints(numberOfPlayers))
                .collect(collectingAndThen(toList(), Lines::new));
    }

    private static Line getBuildWithRandomPoints(int numberOfPlayers) {
        Line.LineBuilder builder = new Line.LineBuilder();
        builder.point(RANDOM.nextBoolean());
        for (int i = 0; i < numberOfPlayers - 2; i++) {
            builder.point(RANDOM.nextBoolean());
        }
        return builder.build();
    }

    public int getHeight() {
        return lines.size();
    }

    public Line getLine(int targetHeight) {
        return lines.get(targetHeight);
    }
}
