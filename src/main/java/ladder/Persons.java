package ladder;

import java.util.*;

public class Persons {
    private final List<Person> persons;

    public Persons(List<String> persons) {
        this.persons = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            this.persons.add(new Person(i, persons.get(i)));
        }
    }

    public int findResultOf(Person person, Ladder ladder) {
        int index = persons.stream()
                .filter(p -> p.equals(person))
                .mapToInt(Person::getIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 사람이 없습니다."));
        return ladder.findFinalIndexOf(index);
    }

    public Map<Person, Integer> findAllFinalIndex(Ladder ladder) {
        Map<Person, Integer> indexs = new HashMap<>();
        for (Person person : persons) {
            indexs.put(person, findResultOf(person, ladder));
        }
        return indexs;
    }

    public int countOfPersons() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

}
