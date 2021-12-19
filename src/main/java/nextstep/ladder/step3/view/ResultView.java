package nextstep.ladder.step3.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.step3.domain.Category;
import nextstep.ladder.step3.domain.Ladder;
import nextstep.ladder.step3.domain.Line;
import nextstep.ladder.step3.domain.Name;
import nextstep.ladder.step3.domain.Players;

public class ResultView {

    private static final String BLANK = " ";
    private static final String LINE = "-----";
    private static final String STRING_FORMAT = "%6s";
    private static final String DELIMITER_JOIN = "";
    private static final String DELIMITER_LINE = "|";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과\n";
    private static final int DEFAULT_BLANK_LENGTH = 5;
    private static final int DEFAULT_PLAYER_INDEX = 0;

    private ResultView() {
    }

    public static void outputResult(Players players, Ladder ladder, Category category) {
        System.out.println(LADDER_RESULT_MESSAGE);
        outputPlayer(players);
        outputLadder(players.getPlayer(DEFAULT_PLAYER_INDEX).length(), ladder);
        outputCategory(category);
    }

    private static void outputLadder(int firstBlankLength, Ladder ladder) {
        ladder.getLadder()
            .stream()
            .map(line -> lineFormat(firstBlankLength, line))
            .forEach(System.out::println);
    }

    private static String lineFormat(int firstBlankLength, Line line) {
        String firstBlank = blank(firstBlankLength);

        return firstBlank + DELIMITER_LINE + line.getLine()
            .stream()
            .map(ResultView::lineOrBlank)
            .collect(Collectors.joining(DELIMITER_LINE)) + DELIMITER_LINE;
    }

    private static String blank(int length) {
        return String.join(DELIMITER_JOIN, Collections.nCopies(length, BLANK));
    }

    private static String lineOrBlank(Boolean isLine) {
        return Boolean.TRUE.equals(isLine) ? LINE : blank(DEFAULT_BLANK_LENGTH);
    }

    private static void outputPlayer(Players players) {
        String player = toJoining(players.getPlayers());
        System.out.println(player.trim());
    }

    private static void outputCategory(Category category) {
        String categoryJoin = toJoining(category.getCategory());
        System.out.println(categoryJoin.trim());
    }

    private static String toJoining(List<Name> inputStrings) {
        return inputStrings.stream()
            .map(ResultView::getFormat)
            .collect(Collectors.joining());
    }

    private static String getFormat(Name result) {
        return String.format(STRING_FORMAT, result);
    }

}
