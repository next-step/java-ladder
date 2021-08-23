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
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    public static int sumAll(List<Integer> numbers) {
//        return Calculator.sumAll(numbers, new Conditional() {
//            @Override
//            public boolean test(Integer number) {
//                return true;
//            }
//        });

//        return Calculator.sumAll(numbers, (number -> true));
        return Calculator.sumAllByCondition(numbers, (number -> true));
    }

    public static int sumAllEven(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            if (number % 2 == 0) {
//                total += number;
//            }
//        }
//        return total;

//        return Calculator.sumAllEven(numbers, new Conditional() {
//            @Override
//            public boolean test(Integer number) {
//                if (number % 2 == 0) {
//                    return true;
//                }
//                return false;
//            }
//        });

//        return Calculator.sumAllEven(numbers, (number -> number % 2 == 0));
        return Calculator.sumAllByCondition(numbers, number -> number % 2 == 0);
    }



    public static int sumAllOverThree(List<Integer> numbers) {
//        int total = 0;
//        for (int number : numbers) {
//            if (number > 3) {
//                total += number;
//            }
//        }
//        return total;

//        return Calculator.sumAllOverThree(numbers, new Conditional() {
//            @Override
//            public boolean test(Integer number) {
//                if (number > 3) {
//                    return true;
//                }
//                return false;
//            }
//        });

//        return Calculator.sumAllOverThree(numbers, (number -> number > 3));
        return Calculator.sumAllByCondition(numbers, (number -> number > 3));
    }
}
