package ladder.view;

import ladder.domain.*;

public class OutputView {
    private static final String MESSAGE_RESULT_TITLE = "실행결과";
    private static final String EMPTY_SPACE = "     ";
    private static final String BAR = "-----";
    private static final String COLUMN = "|";

    private static NameFormatter<Player> playerNameFormatter = new PlayerNameFormatter();
    private static NameFormatter<Prize> prizeNameFormatter = new PrizeNameFormatter();

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
        players.getPlayers().stream()
                .map(player -> String.format(playerNameFormatter.nameFormat(player), player.getName()))
                .forEach(System.out::print);
        printEmptyLine();
    }

    private static void printPrizes(Prizes prizes) {
        prizes.getPrizes().stream()
                .map(prize -> String.format(prizeNameFormatter.nameFormat(prize), prize.getPrize()))
                .forEach(System.out::print);
        printEmptyLine();
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

}
