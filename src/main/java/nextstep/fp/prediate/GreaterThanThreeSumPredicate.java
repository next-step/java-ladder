package nextstep.fp.prediate;

public class GreaterThanThreeSumPredicate implements SumPredicate {

    @Override
    public boolean test(Integer integer) {
        return integer > 3;
    }
}
