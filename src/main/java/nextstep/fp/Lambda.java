package nextstep.fp;

import nextstep.fp.operator.EvenSumOperator;
import nextstep.fp.operator.SumAboveThreeOperator;
import nextstep.fp.operator.SumOperator;
import nextstep.fp.operator.Opertator;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return sumUsingOperator(numbers, new SumOperator());
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumUsingOperator(numbers, new EvenSumOperator());
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumUsingOperator(numbers, new SumAboveThreeOperator());
    }

    private static int sumUsingOperator(List<Integer> numbers, Opertator opertator) {
        int total = 0;
        for (int number : numbers) {
            total = opertator.operate(total, number);
        }
        return total;
    }
}
