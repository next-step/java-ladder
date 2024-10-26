package nextstep.fp;

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
        new Thread(() -> System.out.println("Hello from thread")).start();
    }

    private static int sumAllCommon(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            total += conditional.getConditionalValue(number);
        }
        return total;
    }

    public static int sumAll(List<Integer> numbers) {
        return sumAllCommon(numbers, new Conditional() {
            @Override
            public int getConditionalValue(int number) {
                return number;
            }
        });
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAllCommon(numbers, new Conditional() {
            @Override
            public int getConditionalValue(int number) {
                if (number % 2 == 0) {
                    return number;
                }
                return 0;
            }
        });
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAllCommon(numbers, new Conditional() {
            @Override
            public int getConditionalValue(int number) {
                if (number > 3) {
                    return number;
                }
                return 0;
            }
        });
    }
}
