package nextstep.ladder.view;

import java.util.List;

public class ResultView {
    public static void printResult(List<String> result) {
        System.out.println("실행결과");
        result.forEach(System.out::println);
    }
}
