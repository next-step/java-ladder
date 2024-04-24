package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private List<String> persons;

    public Person(List<String> persons) {
        this.persons = persons;
    }

    public int size() {
        return persons.size();
    }

    public String name() {
        return persons.stream()
                .collect(Collectors.joining("  ", " ", ""));
    }

    public int location(String name) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).equals(name))
                return i;
        }
        throw new IllegalArgumentException("잘못된 사람이름 입니다");
    }

    public String get(int i) {
        return persons.get(i);
    }
}