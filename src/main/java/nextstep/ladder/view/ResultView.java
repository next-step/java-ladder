package nextstep.ladder.view;

import nextstep.ladder.controller.dto.GameResult;
import nextstep.ladder.domain.LadderGame;

public class ResultView {

    public void printLadder(LadderGame ladderGame) {
        printBanner("사다리 결과");
        printPlayersName(ladderGame);
        printLadderResult(ladderGame);
        printPrizes(ladderGame);
    }

    private void printBanner(String message) {
        println("");
        println(message);
    }

    private void printPlayersName(LadderGame ladderGame) {
        println(ladderGame.playersName());
    }

    private void printLadderResult(LadderGame ladderGame) {
        print(ladderGame.ladder());
    }

    private void printPrizes(LadderGame ladderGame) {
        println("");
        print(ladderGame.prizes());
    }

    public boolean printResultBy(String name, GameResult gameResult) {
        printBanner("실행 결과");

        if ("all".equals(name)) {
            printAll(gameResult);
            println("");

            return true;
        }

        print(gameResult.prize(name));
        println("");

        return false;
    }

    public void printAll(GameResult gameResult) {
        gameResult.names()
            .forEach(name -> println(name + " : " + gameResult.prize(name)));
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
