package nextstep.ladder.ui;

import nextstep.ladder.domain.LadderGame;

public class ResultView {
    private static final String GAME_RESULT_HEADER = "\n실행결과\n";

    private ResultView() {
        throw new UnsupportedOperationException("인스턴스를 생성할 수 없습니다.");
    }

    public static void printLadder(LadderGame ladderGame) {
        printHeader();
        printPlayers(ladderGame);
        printGameBoard(ladderGame);
    }

    private static void printHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }

    private static void printGameBoard(LadderGame ladderGame) {
        System.out.println(ladderGame.getGameBoardAsString());
    }

    private static void printPlayers(LadderGame ladderGame) {
        System.out.println(ladderGame.getPlayerAsString());
    }
}
