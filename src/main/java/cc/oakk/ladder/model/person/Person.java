package cc.oakk.ladder.model.person;

import cc.oakk.ladder.util.StringUtils;
import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

import java.util.Objects;

public class Person implements Printable<Person> {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Person(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("빈 값이 넘겨졌습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("5글자를 초과한 이름입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void print(Printer<Person> printer) {
        printer.print(this);
    }
}
