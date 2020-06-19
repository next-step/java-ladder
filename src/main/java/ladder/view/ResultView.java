package ladder.view;

import ladder.domain.ladder.Ladder;

import java.util.List;

public class ResultView {
    public static void printResult(List<String> names, Ladder ladder) {
        System.out.println("실행 결과");
        printNames(names);
        printLadder(ladder);
    }

    private static void printNames(List<String> names) {
        names.forEach(System.out::println);
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }
}
