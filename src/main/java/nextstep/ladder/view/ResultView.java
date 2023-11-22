package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;

import java.util.List;

public class ResultView {

    private static final String SPACE = " ";
    public static final int SIZE_BETWEEN_NAME = 6;
    public static final String TRUE_BRIDGE = "-----";
    public static final String FALSE_BRIDGE = "     ";
    public static final String LADDER_POLE = "|";


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
        List<String> names = ladderGame.playersName();
        names.forEach(name -> print(name + SPACE.repeat(SIZE_BETWEEN_NAME - name.length())));
        println("");
    }

    private void printBooleanLadder(LadderGame ladderGame) {
        List<List<Boolean>> booleanLadder = ladderGame.ladder();

        booleanLadder.forEach(this::printBooleanBridges);
    }

    private void printBooleanBridges(List<Boolean> booleanBridges) {
        booleanBridges.forEach(this::printTruOrNot);

        print(LADDER_POLE);
        println("");
    }

    private void printTruOrNot(boolean booleanBridge) {
        System.out.print(LADDER_POLE);

        if (booleanBridge) {
            print(TRUE_BRIDGE);
            return;
        }

        print(FALSE_BRIDGE);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
