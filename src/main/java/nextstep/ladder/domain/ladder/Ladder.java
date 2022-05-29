package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.person.People;
import nextstep.ladder.domain.person.Person;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.util.ConnectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder from(int height, People people, ConnectStrategy connectStrategy) {
        validateHeight(height);
        List<LadderLine> ladderLines = new ArrayList<>();

        int peopleSize = people.size();
        for (int i = 1; i <= height; i++) {
            ladderLines.add(LadderLine.of(peopleSize, connectStrategy));
        }
        return new Ladder(ladderLines);
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 " + MIN_HEIGHT + "이상이어야 합니다.");
        }
    }

    public Results results(String names) {
        Results results = Results.from(names);
        if (lineLength() != results.size()) {
            throw new IllegalArgumentException("사다리의 가로 길이와 결과의 길이가 같아야 합니다.");
        }
        return results;
    }

    public List<Result> results(People people, Results results) {
        return people.people().stream()
                .map(this::move)
                .map(results::result)
                .collect(Collectors.toList());
    }

    public Position move(Person person) {
        Position position = person.position();
        for (int height = 0; height < ladderLines.size(); height++) {
            position = ladderLines.get(height).move(position);
        }
        return position;
    }

    private int lineLength() {
        return ladderLines.get(0).size();
    }

    @Override
    public String toString() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.joining("\n")) + "\n";
    }


}
