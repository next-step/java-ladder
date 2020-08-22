package ladder.domain;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Persons implements Iterable<Person>, Printable {

    private final List<Person> persons;

    private Persons(List<Person> persons) {
        this.persons = persons;
    }

    public static Persons fromText(String text) {
        List<Person> persons = new ArrayList<>();
        CommaSplitter.split(text)
                .forEach(s -> persons.add(new Person(s)));
        return new Persons(persons);
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
}
