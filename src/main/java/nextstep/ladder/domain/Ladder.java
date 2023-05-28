package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final People people;
    private final ExecuteResults executeResults;
    private final Lines lines;

    public Ladder(People people, ExecuteResults executeResults, int height) {
        if (people.value().size() != executeResults.value().size()) {
            throw new RuntimeException("참여할 사람 수와 실행 결과 수는 일치해야 합니다.");
        }
        this.people = people;
        this.executeResults = executeResults;
        this.lines = new Lines(generateLadder(height));
    }

    public Ladder(People people, ExecuteResults executeResults, Lines mockLines) {
        if (people.value().size() != executeResults.value().size()) {
            throw new RuntimeException("참여할 사람 수와 실행 결과 수는 일치해야 합니다.");
        }
        this.people = people;
        this.executeResults = executeResults;
        this.lines = mockLines;
    }

    private List<Line> generateLadder(int height) {
        return Stream.generate(() -> new Line(people.value().size()))
                .limit(height)
                .collect(Collectors.toList());
    }

    public People people() {
        return people;
    }

    public ExecuteResults executeResults() {
        return executeResults;
    }

    public Lines lines() {
        return lines;
    }
}
