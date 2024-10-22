package nextstep.ladder.domain;

public class PositiveNumberFactory {

    private PositiveNumberFactory() {
        throw new UnsupportedOperationException();
    }

    public static PositiveNumber createPositiveNumber(int number) {
        return new PositiveNumber(number);
    }
}
