package nextstep.fp;

@FunctionalInterface
public interface Calculator {
    boolean isUsable(int number);

    default int plus(int number1, int number2) {
        return number1 + number2;
    }
}
