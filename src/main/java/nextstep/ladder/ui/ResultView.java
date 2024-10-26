package nextstep.ladder.ui;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.LadderGame;

public class ResultView {
    private static final String LADDER_RESULT_HEADER = "\n사다리 결과\n";
    private static final String GAME_RESULT_HEADER = "\n실행 결과\n";

    private ResultView() {
        throw new UnsupportedOperationException("인스턴스를 생성할 수 없습니다.");
    }

    public static void printLadder(LadderGame ladderGame) {
        printLadderResultHeader();
        printPlayers(ladderGame);
        printGameBoard(ladderGame);
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printLadderResultHeader() {
        System.out.println(LADDER_RESULT_HEADER);
    }

    private static void printGameBoard(LadderGame ladderGame) {
        System.out.println(ladderGame.getGameBoardAsString());
    }

    private static void printPlayers(LadderGame ladderGame) {
        System.out.println(ladderGame.getPlayerAsString());
    }

    public static void printResult(GameResult gameResult) {
        printGameResultHeader();
        printGameResult(gameResult);
    }

    private static void printGameResult(GameResult gameResult) {
        System.out.println(gameResult.resultAsString());
    }

    private static void printGameResultHeader() {
        System.out.println(GAME_RESULT_HEADER);
    }
}
