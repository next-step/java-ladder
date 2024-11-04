package nextstep.fp;

@FunctionalInterface
public interface Calculator {
    boolean isUsable(int number);

    default int plus(int number, int result) {
        if (isUsable(number)) {
            return number + result;
        }
        return result;
    }
}
