package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> bridge;

    public Line (int countOfPerson) {
        this.bridge = Stream.iterate(random.nextBoolean(), this::getNextLine)
                .limit(countOfPerson - 1)
                .collect(Collectors.toList());
    }

    private Boolean getNextLine(Boolean previous) {
        return !previous && random.nextBoolean();
    }

    @Override
    public String toString() {
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
