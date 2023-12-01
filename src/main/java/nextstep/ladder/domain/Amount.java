package nextstep.ladder.domain;

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
    public String toString() {
        return amount;
    }
}
