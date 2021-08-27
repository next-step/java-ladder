package nextstep.fp;

public class OverThreeStrategy implements SumStrategy {
    @Override
    public boolean canSum(Integer integer) {
        if (integer > 3) {
            return true;
        }
        return false;
    }
}
