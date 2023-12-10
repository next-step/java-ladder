package ladder.gilbert.view;

import java.util.List;

import ladder.engine.Line;
import ladder.engine.Result;
import ladder.gilbert.domain.data.Goals;
import ladder.gilbert.domain.data.Persons;

public class ResultView {

    public static void showLadder(Persons persons, List<Line> lines, Goals goals) {
        showPersons(persons);
        showLines(lines);
        showGoals(goals);
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

    public static void showResult(Result result, Persons persons, Goals goals) {
        resultTitle();
        for (Integer value: result.keySet()) {
            System.out.println(persons.findName(value) + ":" + goals.get(result.get(value)));
        }
    }

    private static void resultTitle() {
        System.out.println("\n실행결과");
    }

}
