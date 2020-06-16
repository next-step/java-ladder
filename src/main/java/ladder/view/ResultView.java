package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class ResultView {

    private static final String LADDER_RESULT_INTRO_MESSAGE = "실행결과";

    public void displayLadderplayers(Players players) {
        System.out.println(LADDER_RESULT_INTRO_MESSAGE);
        System.out.println(players.getPlayerName());
    }

    public void displayLadder(Ladder ladder) {
        System.out.println(ladder.draw());
    }
}
