package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Persons {
    private List<Person> persons;

    public Persons(String[] names) {
        this(Stream.of(names)
                .map(Person::new)
                .collect(Collectors.toList()));
    }

    public Persons(List<Person> persons) {
        validateEmpty(persons);
        this.persons = persons;
    }

    private void validateEmpty(List<Person> persons) {
        if (persons == null || persons.isEmpty()) {
            throw new IllegalArgumentException("사람 목록은 null 또는 빈 목록일 수 없습니다.");
        }
    }

    public int getSize() {
        return persons.size();
    }
}
