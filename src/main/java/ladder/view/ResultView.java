package ladder.view;

import ladder.domain.data.*;

public class ResultView {

    public static void showPersons(Persons persons) {
        System.out.println("\n사다리 결과\n");
        System.out.println(persons);
    }

    public static void ladderResult(Ladder ladder) {
        ladder.lines().forEach(System.out::println);
        System.out.println(ladder.goals());
        System.out.println();
    }

    public static void goalResult(Goal goal) {
        System.out.println("\n실행결과");
        System.out.println(goal);
    }

}
