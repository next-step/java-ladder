package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Person> personList;

    public Participants(String[] names) {
        this(Arrays.stream(names).map(Person::new).collect(Collectors.toList()));
    }

    public Participants(List<Person> personList) {
        this.personList = personList;
    }

    public int size() {
        return personList.size();
    }

    public List<String> getNames(){
        return personList.stream().map(Person::getName).collect(Collectors.toList());
    }
}
