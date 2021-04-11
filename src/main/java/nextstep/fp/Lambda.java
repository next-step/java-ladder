package nextstep.fp;

import nextstep.fp.strategy.Conditional;

import java.util.List;

public final class Lambda {

    public static final String PRINT_ALL_OLD = "printAllOld";
    public static final String PRINT_ALL_LAMBDA = "printAllLambda";
    public static final String HELLO_FROM_THREAD = "Hello from thread";

    public static final int ZERO = 0;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static final void printAllOld(List<Integer> numbers) {
        System.out.println(PRINT_ALL_OLD);

        // 오래된 메서드라는 이름에 맞게 자체 리팩터링 진행 x
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static final void printAllLambda(List<Integer> numbers) {
        System.out.println(PRINT_ALL_LAMBDA);
        numbers.forEach(System.out::println);
    }

    public static final void runThread() {
        new Thread(() -> System.out.println(HELLO_FROM_THREAD)).start();
    }

    public static final int sumAll(List<Integer> numbers) {
        return sumAllByConditional(numbers, number -> true);
    }

    public static final int sumAllEven(List<Integer> numbers) {
        return sumAllByConditional(numbers, number -> number % TWO == ZERO);
    }

    public static final int sumAllOverThree(List<Integer> numbers) {
        return sumAllByConditional(numbers, number -> number > THREE);
    }

    public static final int sumAllByConditional(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .filter(conditional::test)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
