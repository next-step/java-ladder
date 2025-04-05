package ladder.domain;

import java.util.List;

public class People {
    private final static String DELIMITER = ",";
    private final List<String> people;

    public People(String input) {
        this.people = List.of(input.split(DELIMITER));
    }

    public int size() {
        return people.size();
    }

    public List<String> values() {
        return people;
    }
}
