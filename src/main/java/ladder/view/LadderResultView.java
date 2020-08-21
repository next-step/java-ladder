package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Persons;

public class LadderResultView {
    public static void printPersonWithLadder(Persons persons, Ladder ladder) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        System.out.println(persons.print());
        System.out.println(ladder.print());
    }
}
