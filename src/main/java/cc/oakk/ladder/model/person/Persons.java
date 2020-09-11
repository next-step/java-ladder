package cc.oakk.ladder.model.person;

import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

import java.util.*;
import java.util.function.Consumer;

import static cc.oakk.ladder.util.ValidationUtils.*;

public class Persons implements Printable<Persons> {
    public static final int NOT_FOUND = -1;

    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = Collections.unmodifiableList(throwIfListHasDuplicatedElement(throwIfEmptyList(persons)));
    }

    public Person get(int index) {
        throwIfOutOfListSize(persons, index);
        return persons.get(index);
    }

    public int size() {
        return persons.size();
    }

    public Persons forEach(Consumer<Person> consumer) {
        persons.forEach(throwIfNull(consumer));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons1 = (Persons) o;
        return Objects.equals(persons, persons1.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons);
    }

    @Override
    public void print(Printer<Persons> printer) {
        printer.print(this);
    }

    public int find(Person person) {
        return persons.indexOf(throwIfNull(person));
    }
}
