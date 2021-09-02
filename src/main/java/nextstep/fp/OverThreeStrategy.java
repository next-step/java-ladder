package nextstep.fp;

public class OverThreeStrategy implements SumStrategy {

    public static final int LIMIT_NUMBER = 3;

    @Override
    public boolean canSum(Integer integer) {
        return integer > LIMIT_NUMBER;
    }
}

