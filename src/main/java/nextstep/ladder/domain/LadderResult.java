package nextstep.ladder.domain;

import java.util.List;

public class LadderResult {

    private final Ladder ladder;
    private final List<String> results;

    public LadderResult(Ladder ladder, List<String> results) {
        this.ladder = ladder;
        this.results = results;
    }

    public static LadderResult of(Ladder ladder, List<String> results) {
        return new LadderResult(ladder, results);
    }

    public String person(String name) {
        Persons persons = ladder.persons();
        List<Line> lines = ladder.ladderHeight();

        int position = persons.indexOfPerson(name);

        for (Line line : lines) {
            position = line.currentPosition(position);
        }

        return results.get(position);
    }
}
