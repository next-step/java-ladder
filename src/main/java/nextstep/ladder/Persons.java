package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {

    private List<Person> personList;

    public Persons(String[] nameArray) {
        personList = Arrays.stream(nameArray).
                map(Person::new)
                .collect(Collectors.toList());
    }

    public List<String> getPersonsName() {
        return personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    public int personListSize() {
        return personList.size();
    }
}
