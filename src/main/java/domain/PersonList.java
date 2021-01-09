package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonList {
    private List<Person> personList = new ArrayList<>();

    public void split(String names) {
        this.personList = Stream.of(names.split(","))
                .map(name -> new Person(name))
                .collect(Collectors.toList());
    }

    public int size() {
        return personList.size();
    }
}
