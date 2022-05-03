package nextstep.fp;

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
        return sumUsingOperator(numbers, (num1, num2) -> num1 + num2);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumUsingOperator(numbers, (num1, num2) -> {
            if (num2 % 2 == 0) {
                return num1 + num2;
            }
            return num1;
        });
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumUsingOperator(numbers, (num1, num2) -> {
            if (num2 > 3) {
                return num1 + num2;
            }
            return num1;
        });
    }

    private static int sumUsingOperator(List<Integer> numbers, Opertator opertator) {
        int total = 0;
        for (int number : numbers) {
            total = opertator.operate(total, number);
        }
        return total;
    }
}
