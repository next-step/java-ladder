package ladder.controller.response;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Persons;

import java.util.List;

public class LadderResult {
    private List<String> personNames;
    private List<Line> lines;

    private LadderResult(List<String> personNames, List<Line> lines) {
        this.personNames = personNames;
        this.lines = lines;
    }

    public static LadderResult generateLadderResult(Persons persons, Ladder ladder) {
        return new LadderResult(persons.getNames(), ladder.getLines());
    }

    public List<String> getPersonNames() {
        return this.personNames;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
