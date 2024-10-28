package ladder.domain;

import java.util.Objects;

public class Person {
    private final static int MAX_NAME_LENGTH = 5;
    private final static String MAX_NAME_ERROR_MESSAGE = "이름은 5글자를 넘을 수 없습니다.";

    private final String name;
    private Point point;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int position) {
        this.name = validate(name);
        this.point = new Point(position);
    }

    private String validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_ERROR_MESSAGE);
        }
        return name;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return this.point.getPoint();
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
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

    public void gameResultSave(int personLadderResult) {
        point = new Point(personLadderResult);
    }

}
