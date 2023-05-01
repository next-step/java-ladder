package nextstep.fp.prediate;

public class EvenNumbersSumPredicate implements SumPredicate {

    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}
