package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {

    private final List<Person> personList;

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

    public Integer getPersonIndex(String name){
        return personList.stream()
                .filter(t -> t.isEqualsName(name))
                .map(t -> personList.indexOf(new Person(name)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 참가자는 없습니다."));
    }

    public String getPersonNameByIndex(int index){
        return personList.get(index).getName();
    }
}
