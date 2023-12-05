package ladder.view;

import java.util.List;

import ladder.domain.data.*;

public class ResultView {

    public static void showPersons(Persons persons) {
        System.out.println("\n사다리 결과\n");
        System.out.println(persons);
    }

    public static void showLines(Ladder ladder) {
        ladder.lines().forEach(System.out::println);
    }

    public static void showGoals(Goals goals) {
        System.out.println(goals);
    }

    public static void showResult(Result result) {
        System.out.println("\n실행결과");
        System.out.println(result);
    }

    public static void showResult(List<Result> results) {
        System.out.println("\n실행결과");
        results.forEach(x -> System.out.println(x.formatted()));
    }

}
