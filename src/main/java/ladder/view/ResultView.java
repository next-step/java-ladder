package ladder.view;

import ladder.domain.Attendees;
import ladder.domain.Ladder;

public class ResultView {

    private ResultView() {

    }

    public static void showLadder(Attendees attendees, Ladder ladder) {
        System.out.println("\n실행결과\n");
        System.out.println(attendees.toString());
        System.out.println(ladder.toString());
    }
}
