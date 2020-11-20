package ladder.dto.response;

import ladder.domain.Ladder;
import ladder.domain.Persons;

public class LadderDto {
    private final Persons persons;
    private final Ladder ladder;

    public LadderDto(Persons persons, Ladder ladder) {
        this.persons = persons;
        this.ladder = ladder;
    }

    public Persons getPersons() {
        return persons;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
