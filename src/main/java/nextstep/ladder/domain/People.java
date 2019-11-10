package nextstep.ladder.domain;

import java.util.Objects;

public class People {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE = "참여인원 이름의 최대 길이는 5 입니다.";

    private String name;

    public People(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
