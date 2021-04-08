package nextstep.fp;

public class GreaterThanThreeConditional implements Conditional {
    private static final int CONDITION = 3;
    @Override
    public boolean test(Integer number) {
        return number > CONDITION;
    }
}
