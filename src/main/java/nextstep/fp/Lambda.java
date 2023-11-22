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

    /**
     * 주어진 조건이 만족되는 정수들에 한해 총 합계를 구합니다.
     *
     * @param numbers 정수 리스트
     * @param condition 판별 조건
     *
     * @return 조건이 만족되는 정수들의 합계
     */
    public static int sumAllOnlyIf(List<Integer> numbers, ConditionOnInt condition) {
        return numbers.stream()
                .filter(condition::test)
                .reduce(0, Integer::sum);
    }

    public static int sumAll(List<Integer> numbers) {
        return sumAllOnlyIf(numbers, (value) -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sumAllOnlyIf(numbers, (value) -> value % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sumAllOnlyIf(numbers, (value) -> value > 3);
    }
}