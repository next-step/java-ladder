package nextstep.ladder.step4.domain.player;

import java.util.Objects;
import nextstep.ladder.step4.exception.ArgumentNullPointerException;

public class Name {

    private static final int MAXIMUM_SIZE = 5;

    private final String name;

    public Name(String name) {
        valid(name);
        this.name = name;
    }

    public int length() {
        return name.length();
    }

    private void valid(String name) {
        validEmpty(name);
        validSize(name);
    }

    private void validEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new ArgumentNullPointerException();
        }
    }

    private void validSize(String name) {
        if (name.length() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(String.format("최대 길이(%d)를 초과할 수 없습니다.", MAXIMUM_SIZE));
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
