package refactor.domain;

import java.util.Objects;

public class GamePerson {

    public static final int NAME_LENGTH = 5;

    private String name;

    private GamePerson(String name) {
        this.name = name;
    }

    public static GamePerson valueOf(String name) {
        validationName(name);
        return new GamePerson(name);
    }


    private static void validationName(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 최대 5자까지 등록 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePerson name1 = (GamePerson) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
