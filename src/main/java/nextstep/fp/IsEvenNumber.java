package nextstep.fp;

public class IsEvenNumber implements Conditional {
    private final int CONDITION_NUMBER = 2;

    @Override
    public boolean isCondition(int number) {
        return number % CONDITION_NUMBER == 0;
    }
}
