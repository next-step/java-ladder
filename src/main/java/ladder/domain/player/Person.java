package ladder.domain.player;

import ladder.exception.FormatException;

public class Person {

    private static final int STANDARD_LENGTH = 5;
    private String name;

    public Person(String name) {
        if (name.length() > STANDARD_LENGTH) {
            throw new FormatException();
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);

        for (int i = 0; i < getLenthCount(); i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private int getLenthCount() {
        return STANDARD_LENGTH - this.name.length();
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person)obj;
        return this.name.equals(person.getName());
    }
}
