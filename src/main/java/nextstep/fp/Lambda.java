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

    // 변하는 부분 : 덧셈 조건 (모두 더하기, 짝수만 더하기, 3이 넘는 수 더하기)
    // 변하지 않는 부분 : 반복문을 통해 total에 수 더하기
    public static int sum(List<Integer> numbers, Conditional conditional) {
        int total = 0;
        for (int number : numbers) {
            if (conditional.test(number)) {
                total += number;
            }
        }
        return total;
    }

}
