package ladder.view;

import java.util.List;

import ladder.domain.data.*;

public class ResultView {

    public static void showLadder(Persons persons, Ladder ladder) {
        showPersons(persons);
        showLines(ladder.lines());
        showGoals(ladder.goals());
    }

    private static void showPersons(Persons persons) {
        System.out.println("\n사다리 결과\n");
        System.out.println(persons);
    }

    private static void showLines(List<Line> lines) {
        lines.forEach(System.out::println);
    }

    private static void showGoals(Goals goals) {
        System.out.println(goals);
    }

    public static void showResult(Result result) {
        resultTitle();
        System.out.println(result);
    }

    public static void showResult(List<Result> results) {
        resultTitle();
        results.forEach(x -> System.out.println(x.formatted()));
    }

    private static void resultTitle() {
        System.out.println("\n실행결과");
    }

}
