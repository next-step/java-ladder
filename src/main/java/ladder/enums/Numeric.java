package ladder.enums;

public enum Numeric {

    ZERO(0),
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);

    private int number;

    Numeric(int number) {
        this.number = number;
    }

    public int number(){
        return this.number;
    }
}
