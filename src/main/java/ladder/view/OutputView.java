package ladder.view;

import ladder.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.view.InputView.printEmptyLine;

public class OutputView {
    private static final String MESSAGE_RESULT_TITLE = "실행결과";
    private static final String EMPTY_SPACE = "     ";
    private static final String BAR = "-----";
    private static final String COLUMN = "|";
    private static final String BLANK_TO_FILL_THE_NAME_SPACE = " ";
    private static final int SPACE_FOR_NAME = 5;

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
        int spaceForBlank = SPACE_FOR_NAME - name.length();

        return IntStream.rangeClosed(0, spaceForBlank)
                .mapToObj((integer) -> BLANK_TO_FILL_THE_NAME_SPACE)
                .collect(Collectors.joining())
                .concat(name);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(EMPTY_SPACE);
        line.getBars().stream()
                .map(OutputView::printBars)
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static String printBars(Bar bar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COLUMN);
        if (bar.isExist()) {
            return stringBuilder.append(BAR).toString();
        }
        return stringBuilder.append(EMPTY_SPACE).toString();
    }
}
