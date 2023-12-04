package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class People {

    private final List<Person> people = new ArrayList<>();

    public People(String names) throws Exception {
        String[] nameArr = names.split(",");
        for (String name : nameArr) {
            people.add(new Person(name));
        }
    }

    public List<Person> people() {
        return this.people;
    }

    public int count() {
        return this.people.size();
    }
}
