package nextstep.ladder.domain;

import java.util.Objects;

public class Gift {
    private static final int MAX_GIFT_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE = "상품의 이름의 최대 길이는 5 입니다.";

    private String name;

    public Gift(String name) {
        if (name.length() > MAX_GIFT_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(name, gift.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
