package nextstep.fp;

import java.util.List;
import java.util.function.IntPredicate;

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

    public static int sumAll(List<Integer> numbers, IntPredicate condition) {
        int total = 0;
        for (int number : numbers) {
            total = sumByCondition(number, total, condition);
        }
        return total;
    }

    public static int sumAllEven(List<Integer> numbers, IntPredicate condition) {
        //if (number % 2 == 0)
        return sumAll(numbers, condition);
    }

    public static int sumAllOverThree(List<Integer> numbers, IntPredicate condition) {
        //if (number > 3)
        return sumAll(numbers, condition);
    }

    private static int sumByCondition(int number, int totalSum, IntPredicate condition) {
        if(condition.test(number)){
            totalSum += number;
        }
        return totalSum;
    }
}
