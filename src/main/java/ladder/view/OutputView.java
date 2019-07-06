package ladder.view;

import ladder.domain.*;
import ladder.formatter.*;

public class OutputView {
    private static final String MESSAGE_RESULT_TITLE = "사다리 결과";
    private static final String EMPTY_SPACE = "     ";
    private static final String BAR = "-----";
    private static final String COLUMN = "|";
    private static final String MESSAGE_FOR_SINGLE_RESULT = "실행 결과";

    private static DataPrintFormatter<Players> playersPrintFormatter = new PlayersPrintFormatter();
    private static DataPrintFormatter<Prizes> prizesPrintFormatter = new PrizesPrintFormatter();

    public static void drawLadder(Players players, Ladder ladder, Prizes prizes) {
        printResultTitle();
        printPlayers(players);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private static void printResultTitle() {
        printEmptyLine();
        System.out.println(MESSAGE_RESULT_TITLE);
        printEmptyLine();
    }

    private static void printPlayers(Players players) {
        System.out.println(playersPrintFormatter.dataPrintFormat(players));
    }

    private static void printPrizes(Prizes prizes) {
        System.out.println(prizesPrintFormatter.dataPrintFormat(prizes));
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

    private static void printEmptyLine() {
        System.out.println();
    }

    public static void printSingleResult(String resultForWantedPlayer) {
        System.out.println(MESSAGE_FOR_SINGLE_RESULT);
        System.out.println(resultForWantedPlayer);
    }
}
