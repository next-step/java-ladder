package ladder.dto;

import java.util.List;

public class PersonsDto {
    private final List<PersonDto> persons;

    public PersonsDto(List<PersonDto> persons) {
        this.persons = persons;
    }

    public List<PersonDto> getPersons() {
        return persons;
    }
}
