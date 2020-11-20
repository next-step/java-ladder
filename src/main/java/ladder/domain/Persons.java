package ladder.domain;

import ladder.dto.response.PersonsDto;

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

    public PersonsDto getPersonsDto() {
        return persons.stream()
                .map(Person::getPersonDto)
                .collect(collectingAndThen(toList(), PersonsDto::new));
    }
}
