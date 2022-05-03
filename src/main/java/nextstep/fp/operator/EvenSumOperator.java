package nextstep.fp.operator;

public class EvenSumOperator implements Opertator {
    @Override
    public int operate(int num1, int num2) {
        if (num2 % 2 == 0) {
            return num1 + num2;
        }
        return num1;
    }
}
