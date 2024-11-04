package ladder.domain;

import java.util.Objects;

public class Person {
    public static final String ALL = "all";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_ERROR_MESSAGE = "이름은 5글자를 넘을 수 없습니다.";
    private static final String ALL_ERROR = "all은 사용자 이름으로 사용 할 수 없습니다.";

    private final String name;
    private Position position;

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int position) {
        this.name = validate(name);
        this.position = new Position(position);
    }

    private String validate(String name) {
        isAll(name);
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_ERROR_MESSAGE);
        }
        return name;
    }

    private void isAll(String name) {
        if (name.equalsIgnoreCase(ALL)) {
            throw new IllegalArgumentException(ALL_ERROR);
        }
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return this.position.getPosition();
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void gameResultSave(int personLadderResult) {
        position = new Position(personLadderResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
