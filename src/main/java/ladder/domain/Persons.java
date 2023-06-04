package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Persons {
    public static final String DELIMITER = ",";
    public static final int MIN_PERSON_COUNT = 2;
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        if (persons.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("이름은 2개 이상 입력되어야 합니다.");
        }

        this.persons = persons;
    }

    public static Persons of(String namesOfPersons) {
        if (namesOfPersons == null || namesOfPersons.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        String[] names = namesOfPersons.split(DELIMITER);

        return new Persons(IntStream.range(0, names.length)
                .mapToObj(i -> new Person(names[i], i))
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public int getCount() {
        return persons.size();
    }

    public String[] getNames() {
        return persons.stream()
                .map(Person::toString)
                .toArray(String[]::new);
    }

    private Person getPerson(String name) {
        return persons.stream()
                .filter(x -> x.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 이름이 참여자에 존재하지 않습니다."));
    }

    public List<Person> getList(String name) {
        if (name.equals("all")) {
            return persons;
        }

        return Arrays.asList(persons.stream()
                .filter(x -> x.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 이름이 참여자에 존재하지 않습니다.")));
    }
}
