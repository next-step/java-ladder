package nextstep.ladder.domain;

import java.util.Objects;

public class Amount {
    private final String amount;

    public Amount(String amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(String amount) {
        checkAmountSizeIsValid(amount);
    }

    private void checkAmountSizeIsValid(String amount) {
        if (amount.isEmpty()) {
            throw new IllegalArgumentException("금액을 입력해 주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return Objects.equals(amount, amount1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return amount;
    }
}
