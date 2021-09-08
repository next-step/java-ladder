package nextstep.fp;

public class SumAllStrategy implements SumAll {

    private int total = 0;

    @Override
    public void sum(int number) {
        total += number;
    }

    @Override
    public void sumEven(int number) {
        if (number % 2 == 0)
            total += number;
    }

    @Override
    public void sumOverThree(int number) {
        if (number > 3)
            total += number;
    }

    @Override
    public int total() {
        return total;
    }
}
