package ladder.gilbert.domain.data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.gilbert.domain.exception.LadderException;

public class Persons {

    private final List<Person> persons;

    public Persons(String[] names) {
        this(IntStream.range(0, names.length)
            .mapToObj(i -> new Person(names[i], i))
            .collect(Collectors.toList())
        );
    }

    public Persons(List<Person> persons) {
        validate(persons);
        this.persons = new ArrayList<>(persons);
    }

    private void validate(List<Person> persons) {
        if (!isValid(persons)) {
            throw new LadderException("중복된 사람이 있습니다.");
        }
    }

    private boolean isValid(List<Person> persons) {
        return persons.size() == new HashSet<>(persons).size();
    }

    public Integer toOrder(Person target) {
        return persons.stream()
            .filter(target::equals)
            .map(Person::order)
            .findAny()
            .orElseThrow(() -> new LadderException("게임에 참여한 사람의 결과만 볼 수 있습니다."));
    }

    public Name findName(int personOrder) {
        return persons.get(personOrder).name();
    }

    @Override
    public String toString() {
        return persons.stream()
            .map(Person::formatted)
            .collect(Collectors.joining());
    }

    public int size() {
        return persons.size();
    }
}
