package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;

public class ResultView {

    public void printLadder(LadderGame ladderGame) {
        printBanner();
        printPlayersName(ladderGame);
        printBooleanLadder(ladderGame);
    }

    private void printBanner() {
        println("");
        println("===== 실행 결과 =====");
        println("");
    }

    private void printPlayersName(LadderGame ladderGame) {
        println(ladderGame.playersName());
    }

    private void printBooleanLadder(LadderGame ladderGame) {
        print(ladderGame.ladder());
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
