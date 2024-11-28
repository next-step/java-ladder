package nextstep.ladder.dto;

import java.util.Objects;

public class Value {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public Value(String name) {
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
        Value value1 = (Value) o;
        return Objects.equals(name, value1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
