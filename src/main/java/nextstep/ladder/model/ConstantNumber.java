package nextstep.ladder.model;

public enum ConstantNumber {
    ZERO(0),
    ONE(1),
    TWO(2);

    private final int value;

    ConstantNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
