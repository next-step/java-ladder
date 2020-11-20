package ladder.dto.request;

import java.util.List;

public class PersonsDto {
    private final List<String> persons;

    public PersonsDto(List<String> persons) {
        this.persons = persons;
    }

    public List<String> getPersons() {
        return persons;
    }
}
