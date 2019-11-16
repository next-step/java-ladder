package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    private static final String DELIMITER = ",";
    private static final int NAME_LENGTH = 5;
    private List<String> people;

    public People(String names) {
        this.people = createPeople(names);
    }

    private List<String> createPeople(String names) {
        people = Arrays.asList(names.split(DELIMITER));

        return validateName(people);
    }

    public List<String> validateName(List<String> people) {
        return people.stream()
                .filter(person -> person.length() <= NAME_LENGTH)
                .collect(Collectors.toList());
    }

    public int size() {
        return people.size();
    }

    public List<String> getPeople() {
        return new ArrayList<>(people);
    }
}
