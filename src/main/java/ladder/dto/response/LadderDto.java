package ladder.dto.response;

import ladder.domain.Persons;

public class LadderDto {
    private final Persons persons;

    public LadderDto(Persons persons) {
        this.persons = persons;
    }

    public Persons getPersons() {
        return persons;
    }
}
