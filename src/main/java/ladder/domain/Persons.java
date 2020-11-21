package ladder.domain;

import ladder.dto.PersonsDto;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Persons {
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public int getSize() {
        return persons.size();
    }

    public PersonsDto exportPersonsDto() {
        return persons.stream()
                .map(Person::exportPersonDto)
                .collect(collectingAndThen(toList(), PersonsDto::new));
    }
}
