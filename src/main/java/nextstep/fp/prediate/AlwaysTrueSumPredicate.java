package nextstep.fp.prediate;


public class AlwaysTrueSumPredicate implements SumPredicate {

    @Override
    public boolean test(Integer integer) {
        return true;
    }
}
