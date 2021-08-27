package nextstep.fp;

public class EvenSumStrategy implements SumStrategy {
    @Override
    public boolean canSum(Integer integer) {
        if (integer % 2 == 0) {
            return true;
        }
        return false;
    }
}
