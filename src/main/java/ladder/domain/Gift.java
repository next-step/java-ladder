package ladder.domain;

import java.util.InputMismatchException;
import java.util.Objects;

public class Gift {
    private final String value;

    public Gift(String gift) {
        validate(gift);
        this.value = gift;
    }

    private void validate(String gift) {
        if (gift.isEmpty()) {
            throw new InputMismatchException("결과명은 공백일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(value, gift.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
