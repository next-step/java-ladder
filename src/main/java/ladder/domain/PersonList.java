package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PersonList {

    private List<Person> personList = new ArrayList<>();

    public PersonList(List<Person> personList) {
        this.personList = personList;
    }

    public PersonList(String[] personData) {
        if (Arrays.stream(personData).distinct().count() != Arrays.stream(personData).count()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        IntStream.range(0, personData.length).forEach(i -> {
            Person person = new Person(personData[i], i);
            personList.add(person);
        });
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public int listSize() {
        return personList.size();
    }

    public void add(Person person) {
        personList.add(person);
    }

    public void movePersons(Ladder ladder) {
        personList.forEach(p -> ladder.getLines().forEach(line -> p.move(line.getPoints())));
    }
}
