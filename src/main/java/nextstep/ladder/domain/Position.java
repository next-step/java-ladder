package nextstep.ladder.domain;

public class Position {

    private int value;

    public Position(int value) {
        this.value = value;
    }

    public Position() {
        this.value = 0;
    }

    public int preIncrease() {
        return ++value;
    }

    public int postIncrease() {
        return value++;
    }

    public int preDecrease() {
        return --value;
    }

    public int postDecrease() {
        return value--;
    }

    public int getValue() {
        return value;
    }
}
