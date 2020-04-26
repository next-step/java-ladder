package ladder.controller.response;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Persons;

import java.util.List;

public class LadderDto {
    private List<String> personNames;
    private List<Line> lines;
    private List<String> ladderResult;

    private LadderDto(List<String> personNames, Ladder ladder) {
        this.personNames = personNames;
        this.lines = ladder.getLines();
        this.ladderResult = ladder.getLadderResult().getValues();
    }

    public static LadderDto getInstance(Persons persons, Ladder ladder) {
        return new LadderDto(persons.getNames(), ladder);
    }

    public List<String> getPersonNames() {
        return this.personNames;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public List<String> getLadderResult() {
        return this.ladderResult;
    }
}
