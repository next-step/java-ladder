package ladder.view;

import ladder.domain.LadderGame;

public class ResultView {

    public static void showLadder(LadderGame ladderGame) {
        System.out.println("\n실행결과\n");
        System.out.println(ladderGame.getParticipantsString());
        System.out.println(ladderGame.getLadderString());
    }
}
