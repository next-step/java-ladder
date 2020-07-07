package ladder.view;

import ladder.domain.GameAttendees;
import ladder.domain.Ladder;
import ladder.domain.LadderCompensation;

public final class LadderView {

    private LadderView() {}

    public static void drawGameAttendees(final GameAttendees gameAttendees) {
        System.out.println(gameAttendees);
    }

    public static void drawLadderCompensation(final LadderCompensation ladderCompensation) {
        System.out.println(ladderCompensation);
    }

    public static void drawLadder(final Ladder ladder) {
        System.out.println(ladder);
    }

}
