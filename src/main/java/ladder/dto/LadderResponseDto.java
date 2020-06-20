package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Persons;

public class LadderResponseDto {

    private final Persons persons;
    private final Ladder ladder;
    private final LadderResults ladderResults;

    public LadderResponseDto(Persons persons, Ladder ladder, LadderResults ladderResults) {
        this.persons = persons;
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public Persons getPersons() {
        return persons;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }
}
