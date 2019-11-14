package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    private static final String DELIMITER = ",";
    private List<String> people;

    public People(String names) {
        this.people = createPeople(names);
    }

    public List<String> createPeople(String names) {
        people = Arrays.asList(names.split(DELIMITER));
        return validateName(people);
    }

    public List<String> validateName(List<String> people) {
        return people.stream()
                .filter(p -> p.length() <= 5)
                .collect(Collectors.toList());
    }

    public List<String> getPeople() {
        return new ArrayList<>(people);
    }
}
