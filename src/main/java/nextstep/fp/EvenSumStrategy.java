package nextstep.fp;

public class EvenSumStrategy implements SumStrategy {
    @Override
    public boolean canSum(Integer integer) {
        return integer % 2 == 0;
    }
}
