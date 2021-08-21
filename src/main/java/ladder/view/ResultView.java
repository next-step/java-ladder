package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.utils.StringUtil;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RESULT_MESSAGE_PRE = "실행결과";
    private static final String LADDER_VERTICAL_DISPLAY = "|";
    private static final String LADDER_HORIZONTAL_DISPLAY = "-";
    private static final String LADDER_EMPTY_DISPLAY = " ";

    private ResultView() {
    }

    public static void displayLadderGameResult(Ladder ladder, String... usernames) {
        System.out.print(LINE_SEPARATOR + RESULT_MESSAGE_PRE + LINE_SEPARATOR + LINE_SEPARATOR);
        displayUsers(usernames);
        System.out.print(LINE_SEPARATOR);
        displayLadders(ladder.getLines());
    }

    private static void displayUsers(String[] userNames) {
        Arrays.stream(userNames).map(ResultView::getUserToFormat)
                .forEach(System.out::print);
    }

    private static String getUserToFormat(String input) {
        return StringUtil.fillRightBlank(input, LadderGame.MAX_USERNAME_LENGTH + 1);
    }

    private static void displayLadders(List<Line> lines) {
        lines.stream()
                .map(ResultView::getLine)
                .forEach(System.out::println);
    }

    private static String getLine(Line line) {
        return line.getDirections().stream()
                .map(ResultView::getDirection)
                .reduce(String::concat).orElse("");
    }

    private static String getDirection(Direction direction) {
        if (direction.equals(Direction.RIGHT)) {
            return getDirectionToFormat(LADDER_HORIZONTAL_DISPLAY);
        }
        return getDirectionToFormat(LADDER_EMPTY_DISPLAY);
    }

    private static String getDirectionToFormat(String input) {
        return LADDER_VERTICAL_DISPLAY + StringUtil.fillGivenString(input, LadderGame.MAX_USERNAME_LENGTH);
    }
}
