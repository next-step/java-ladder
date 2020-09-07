package cc.oakk.ladder.model;

import cc.oakk.ladder.util.StringUtils;
import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

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
    public void print(Printer<Person> printer) {
        printer.print(this);
    }
}
