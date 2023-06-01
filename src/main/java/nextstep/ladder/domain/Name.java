package nextstep.ladder.domain;

import java.util.Objects;

public class Name {
    public static final int MAX_LENGTH = 5;
    public static final String UNAVAILABLE_NAME = "all";

    private final String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 최대 " + MAX_LENGTH + "글자까지 부여할 수 있습니다. (부적절한 이름: " + name + ")");
        }
        if (name.equals(UNAVAILABLE_NAME)) {
            throw new IllegalArgumentException("사용 불가능한 이름입니다. (불가능한 이름: " + name + ")");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
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
