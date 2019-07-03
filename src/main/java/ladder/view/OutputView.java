package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;

import static ladder.view.InputView.printEmptyLine;

public class OutputView {
    private static final String MESSAGE_RESULT_TITLE = "실행결과";

    public static void printResult(Players players, Ladder ladder) {
        printResultTitle();
        printPlayers(players);
        printLadder(ladder);
    }

    private static void printResultTitle() {
        printEmptyLine();
        System.out.println(MESSAGE_RESULT_TITLE);
        printEmptyLine();
    }

    private static void printPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.print(player.getName());
        }
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(line.getBars());
        }
    }
}
