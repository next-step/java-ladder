package ladder.domain;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public class Person {

    public static final int MAX_LENGTH = 5;
    private static final String MESSAGE_NULL_OR_BLANK = "이름은 공란이거나 Null 일 수 없습니다.";

    private final String name;
    private final Position position;

    public Person(String name, int maxPosition, int position) {
        this(name, new Position(maxPosition, position));
    }

    public Person(String name, Position position) {
        if (isNullOrBlank(name)) {
            throw new InvalidNameException(MESSAGE_NULL_OR_BLANK);
        }
        if (isLowerMaxLength(name)) {
            throw new InvalidNameException();
        }
        this.name = name;
        this.position = position;
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isLowerMaxLength(String value) {
        return value.length() > MAX_LENGTH;
    }

    public String name() {
        return name;
    }

    public int withoutNameSize(int size) {
        return size - name.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
