package nextstep.fp;

public class IsGreaterThanThree implements Conditional {
    private final int CONDITION_NUMBER = 3;

    @Override
    public boolean isCondition(int number) {
        return number > CONDITION_NUMBER;
    }
}
