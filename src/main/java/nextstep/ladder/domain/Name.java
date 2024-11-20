package nextstep.ladder.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (inValid(name)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        this.name = name;
    }

    private static boolean inValid(String name) {
        return name.length() > MAX_LENGTH || name.isBlank();
    }

    public String getName() {
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
