package ladder.view;

import ladder.domain.*;

import java.util.Scanner;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NAME_FORMAT_EXPRESSION = "%5s";
    private static final String PRIZE_FORMAT_EXPRESSION = "%-5s";

    private static final String LADDER_STRAIGHT_LINE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY_LINE = "     ";
    private static final String BLANK_STRING = " ";
    private static final String EMPTY_STRING = "";

    private static final String LADDER_RESULT_MESSAGE = "사다리 결과\n";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String WHO_WANT_TO_SEE_RESULT = "결과를 보고 싶은 사람은?";
    private static final String ALL = "all";

    private OutputView() {}

    public static void printPlayerName(Players players) {
        System.out.println(LADDER_RESULT_MESSAGE);
        players.getPlayers()
               .stream()
               .map(Player::name)
               .map(playerName -> formatName(playerName.value()))
               .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLines()
              .stream()
              .map(OutputView::printLine)
              .forEach(System.out::println);
    }

    public static void printPrize(final Prizes prizes) {
        prizes.getPrizes()
              .stream()
              .map(Prize::getPrize)
              .map(OutputView::formatPrize)
              .forEach(System.out::print);
        System.out.println();
    }

    static String formatName(String name) {
        return String.format(NAME_FORMAT_EXPRESSION, name) + BLANK_STRING;
    }

    static String formatPrize(String name) {
        return String.format(PRIZE_FORMAT_EXPRESSION, name) + BLANK_STRING;
    }

    private static String printLine(final Line line) {
        return line.getLine()
                   .stream()
                   .map(isLine -> isLine ? LADDER_LINE : LADDER_EMPTY_LINE)
                   .collect(Collectors.joining(LADDER_STRAIGHT_LINE, EMPTY_STRING, LADDER_STRAIGHT_LINE));
    }

    public static void printResult(final Result result) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(WHO_WANT_TO_SEE_RESULT);
            String name = scanner.nextLine();
            if (ALL.equals(name)) {
                break;
            }
            System.out.println(result.findOne(name));
            System.out.println();
        }

        System.out.println(RESULT_MESSAGE);
        result.getResult()
              .keySet()
              .forEach(player -> System.out.println(player.name().value() + " : " + result.get(player).getPrize()));
    }
}
