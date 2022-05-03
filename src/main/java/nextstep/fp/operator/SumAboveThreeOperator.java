package nextstep.fp.operator;

public class SumAboveThreeOperator implements Opertator {
    @Override
    public int operate(int num1, int num2) {
        if (num2 > 3) {
            return num1 + num2;
        }
        return num1;
    }
}
