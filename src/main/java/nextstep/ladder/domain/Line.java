package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomLineGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfParticipant) {
        this(generateRandomLine(countOfParticipant));
        checkForConsecutiveTrues(this.getPoints());
    }

    public Line(int countOfParticipant, LineGenerator lineGenerator) {
        this(generateRandomLine(countOfParticipant, lineGenerator));
        checkForConsecutiveTrues(this.getPoints());
    }

    private static ArrayList<Boolean> generateRandomLine(int countOfParticipant) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        ArrayList<Boolean> line = new ArrayList<>();
        line.add(false); // 사다리 라인의 맨 왼쪽은 생성될 수 없다.
        for (int i = 1; i < countOfParticipant; i++) {
            boolean shouldGenerateLine = !line.get(i - 1) && lineGenerator.generateLine();
            line.add(shouldGenerateLine);
        }
        return line;
    }

    private static ArrayList<Boolean> generateRandomLine(int countOfParticipant, LineGenerator lineGenerator) {
        ArrayList<Boolean> line = new ArrayList<>();
        line.add(false); // 사다리 라인의 맨 왼쪽은 생성될 수 없다.
        for (int i = 1; i < countOfParticipant; i++) {
            boolean shouldGenerateLine = lineGenerator.generateLine();
            line.add(shouldGenerateLine);
        }
        return line;
    }

    private static void checkForConsecutiveTrues(List<Boolean> points) {
        IntStream.range(0, points.size() - 1)
                .filter(i -> points.get(i) && points.get(i + 1))
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("사다리 라인은 연속으로 겹칠 수 없습니다.");
                });
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
