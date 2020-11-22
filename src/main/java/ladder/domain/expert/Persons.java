package ladder.domain.expert;

import ladder.dto.PersonsDto;
import ladder.exception.PersonNotFoundException;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Persons {
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public int size() {
        return persons.size();
    }

    public int getPosition(Person person) {
        int position = persons.indexOf(person);
        if (position < 0) {
            throw PersonNotFoundException.getInstance();
        }
        return position;
    }

    public PersonsDto exportPersonsDto() {
        return persons.stream()
                .map(Person::exportPersonDto)
                .collect(collectingAndThen(toList(), PersonsDto::new));
    }
}
