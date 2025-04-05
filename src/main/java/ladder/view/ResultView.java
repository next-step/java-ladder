package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.People;

public class ResultView {
    public static void printLadder(People people, Ladder ladder) {
        System.out.println("실행결과");
        printPeople(people);
        printLadder(ladder);
    }

    private static void printPeople(People people) {
        people.values().forEach(v -> System.out.printf("%-6s", v.name()));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.lines().forEach(l -> {
            l.points().values().forEach(p -> {
                System.out.print("|");
                System.out.printf("%5s", p.connected() ? "-----" : "");
            });
            System.out.println();
        });
    }
}
