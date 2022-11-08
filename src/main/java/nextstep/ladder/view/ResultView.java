package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;

public class ResultView {

    private ResultView() {}

    public static void printLadderGame(LadderGame ladderGame) {
        System.out.println("\n실행결과\n");
        System.out.println(ladderGame.toString());
    }

}
