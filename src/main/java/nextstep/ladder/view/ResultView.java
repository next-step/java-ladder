package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;

import java.util.Arrays;

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

    public void printResultBy(String name, LadderGame ladderGame) {
        printBanner("실행 결과");
        print(ladderGame.findReusltBy(name));
    }

    public void printResultAll(LadderGame ladderGame) {
        printBanner("실행 결과");

        String[] names = ladderGame.playersName().split("\\s+");
        Arrays.stream(names)
            .forEach(name -> println(name + " : " + ladderGame.findReusltBy(name)));
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
