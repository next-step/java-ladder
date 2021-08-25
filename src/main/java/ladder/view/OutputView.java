package ladder.view;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.result.Result;
import ladder.domain.user.User;
import ladder.utils.StringUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RESULT_MESSAGE_PRE = "사다리 결과";
    private static final String RESULT_MESSAGE_RESULT = "실행 결과";
    private static final String LADDER_VERTICAL_DISPLAY = "|";
    private static final String LADDER_HORIZONTAL_DISPLAY = "-";
    private static final String EMPTY_DISPLAY = " ";

    private OutputView() {
    }

    public static void displayLadderGameResult(final Ladder ladder, final String[] usernames, final String[] results) {
        System.out.print(LINE_SEPARATOR + RESULT_MESSAGE_PRE + LINE_SEPARATOR + LINE_SEPARATOR);
        displayStartOrEndPoint(usernames);
        System.out.print(LINE_SEPARATOR);
        displayLadders(ladder.getLines());
        displayStartOrEndPoint(results);
    }

    private static void displayStartOrEndPoint(final String[] values) {
        Arrays.stream(values).map(OutputView::getPointToFormat)
                .forEach(System.out::print);
    }

    private static String getPointToFormat(final String input) {
        return StringUtil.fillRightBlank(input, User.MAX_NAME_LENGTH + 1);
    }

    private static void displayLadders(final List<Line> lines) {
        lines.stream()
                .map(OutputView::getLine)
                .forEach(System.out::println);
    }

    private static String getLine(final Line line) {
        return line.getDirections().stream()
                .map(OutputView::getDirection)
                .reduce(String::concat).orElse(EMPTY_DISPLAY);
    }

    private static String getDirection(final Direction direction) {
        if (direction.equals(Direction.RIGHT)) {
            return getDirectionToFormat(LADDER_HORIZONTAL_DISPLAY);
        }
        return getDirectionToFormat(EMPTY_DISPLAY);
    }

    private static String getDirectionToFormat(final String input) {
        return LADDER_VERTICAL_DISPLAY + StringUtil.fillGivenString(input, User.MAX_NAME_LENGTH);
    }

    public static void result(Result result) {
        System.out.print(LINE_SEPARATOR);
        System.out.print(RESULT_MESSAGE_RESULT);
        System.out.print(LINE_SEPARATOR);
        System.out.print(result);
    }

    public static void result(HashMap<User, Result> map) {
        for (Map.Entry<User, Result> userResultEntry : map.entrySet()) {
            System.out.print(userResultEntry.getKey());
            System.out.print(" : ");
            System.out.print(userResultEntry.getValue());
            System.out.print(LINE_SEPARATOR);
        }
    }
}
