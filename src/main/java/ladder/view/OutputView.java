package ladder.view;

import ladder.model.Ladder;
import ladder.model.Players;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void show(String message) {
        System.out.println(message);
    }

    public static void nextLine() {
        System.out.println();
    }

    public static void showResultMessage() {
        show("실행결과");
    }

    public static void showPlayersName(Players players) {
    }

    public static void showLadder(Ladder ladder) {
    }
}
