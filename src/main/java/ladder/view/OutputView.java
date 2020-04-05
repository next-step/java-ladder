package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;

import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT_EXPRESSION = "%5s";
    private static final String LADDER_STRAIGHT_LINE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY_LINE = "     ";
    private static final String BLANK_STRING = " ";
    private static final String EMPTY_STRING = "";

    private OutputView() {}

    public static void printPlayerName(Players players) {
        System.out.println(RESULT_MESSAGE);
        players.getPlayers()
               .stream()
               .map(player -> formatName(player.getName()))
               .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLines()
              .stream()
              .map(OutputView::printLine)
              .forEach(System.out::println);
    }

    private static String printLine(final Line line) {
        return line.getLine()
                   .stream()
                   .map(isLine -> isLine ? LADDER_LINE : LADDER_EMPTY_LINE)
                   .collect(Collectors.joining(LADDER_STRAIGHT_LINE, EMPTY_STRING, LADDER_STRAIGHT_LINE));
    }

    // TODO : 테스트를 위한 public 접근 제한자, private로 수정할 것.
    public static String formatName(String name) {
        return String.format(NAME_FORMAT_EXPRESSION, name) + BLANK_STRING;
    }
}
