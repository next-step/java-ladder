package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        players.getPlayers().stream()
                .map(OutputView::adjustNameLength)
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static String adjustNameLength(Player player) {
        String name = player.getName();
        int spaceForBlank = 5 - name.length();

        return IntStream.rangeClosed(0, spaceForBlank)
                .mapToObj((integer) -> " ")
                .collect(Collectors.joining())
                .concat(name);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        line.getBars().stream()
                .map(OutputView::printBars)
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static String printBars(Boolean bar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|");
        if (bar) {
            return stringBuilder.append("-----").toString();
        }
        return stringBuilder.append("     ").toString();
    }
}
