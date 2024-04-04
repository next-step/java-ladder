package ladder.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> bridge;

    public Line(List<Boolean> bridge) {
        if (hasAdjacentBridge(bridge)) {
            throw new IllegalArgumentException("사다리의 가로줄은 이어질 수 없습니다.");
        }

        this.bridge = bridge;
    }

    private boolean hasAdjacentBridge(List<Boolean> bridge) {
        return IntStream.range(0, bridge.size() - 1)
                .anyMatch(i -> bridge.get(i) && bridge.get(i + 1));
    }

    public static Line generateLine(int countOfPerson, LineGeneratorStrategy generator) {
        final List<Boolean> bridge = Stream
                .iterate(generator.nextBoolean(), previous -> Line.getNextLine(previous, generator))
                .limit(countOfPerson - 1)
                .collect(Collectors.toList());
        return new Line(bridge);
    }

    private static boolean getNextLine(boolean previous, LineGeneratorStrategy generator) {
        return !previous && generator.nextBoolean();
    }

    public String lineToString() {
        StringJoiner joiner = new StringJoiner("|", "     |", "|");
        this.bridge
                .stream()
                .map(this::bridgeToString)
                .forEach(joiner::add);
        return joiner.toString();
    }

    private String bridgeToString(Boolean bridge) {
        return bridge ? "-----" : "     ";
    }
}
