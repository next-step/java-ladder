package nextstep.fp;

public class EvenConditional implements Conditional{
    private static final int EVEN = 2;

    @Override
    public boolean test(Integer number) {
        return number % EVEN == 0;
    }
}
