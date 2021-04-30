package ladder.domain;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Names implements Iterable<Person>{
    private final List<Person> people;

    public Names(String[] names) {
        this(
                Arrays.stream(names)
                        .map(Person::new)
                        .collect(Collectors.toList())
        );
    }

    public Names(List<Person> people) {
        this.people = people;
    }

    public int count() {
        return people.size();
    }

    public Person get(int index) {
        return people.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(people, names1.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    @Override
    public void forEach(Consumer<? super Person> action) {
        people.forEach(action);
    }

    @Override
    public Spliterator<Person> spliterator() {
        return people.spliterator();
    }
}
