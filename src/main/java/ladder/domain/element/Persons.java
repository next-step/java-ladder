package ladder.domain.element;

import ladder.domain.common.Printable;
import ladder.util.CommaSplitter;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

public class Persons implements Iterable<Persons.Person>, Printable {

    private final List<Person> persons;
    private final Map<String, Person> nameMap = new HashMap<>();

    private Persons(List<Person> persons) {
        this.persons = persons;
        persons.forEach(person -> nameMap.put(person.getName(), person));
    }

    public static Persons fromText(String text) {
        List<Person> persons = new ArrayList<>();
        CommaSplitter.split(text)
                .forEach(s -> persons.add(new Person(s)));
        return new Persons(persons);
    }

    public Person get(int index) {
        return persons.get(index);
    }

    public Person get(String name) {
        return Optional.ofNullable(nameMap.get(name))
                .orElseThrow(() -> new PersonNameNotFoundException(name));
    }

    public int size() {
        return persons.size();
    }

    @Nonnull
    @Override
    public Iterator<Person> iterator() {
        return persons.iterator();
    }

    @Override
    public String print() {
        return persons.stream()
                .map(Person::print)
                .collect(Collectors.joining(" "));
    }

    public static class Person extends LadderElement {

        public Person(String name) {
            super(name);
        }
    }
}
