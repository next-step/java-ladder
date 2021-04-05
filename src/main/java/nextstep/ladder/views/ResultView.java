package nextstep.ladder.views;

import nextstep.ladder.domain.*;
import nextstep.ladder.utils.StringUtils;

import java.util.stream.Collectors;

public class ResultView {
    private final static int DISPLAY_BLANK_LENGTH = 5;
    private final static String BLANK_SEPARATOR = " ";
    private final static String ENTER = System.lineSeparator();

    public static void showLadder(GameResult result) {
        String stringBuilder = "실행 결과" +
                ENTER +
                getPlayersNames(result.players()) +
                ENTER +
                getLadder(result.ladder());
        System.out.println(stringBuilder);
    }

    public static String getPlayersNames(Players players) {
        return players.names()
                .stream()
                .map(Player::name)
                .map(ResultView::getPlayerName)
                .collect(Collectors.joining(BLANK_SEPARATOR));
    }

    public static String getPlayerName(String name) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH - name.length()) + name;
    }

    public static String getLadder(Ladder ladder) {
        return ladder.lines()
                .stream()
                .map(ResultView::getLine)
                .collect(Collectors.joining(ENTER));
    }

    public static String getLine(Line line) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH) +
                line.points()
                        .stream()
                        .map(Point::nextDirection)
                        .map(ResultView::getDisplayDirection)
                        .collect(Collectors.joining());
    }

    public static String getDisplayDirection(Direction direction) {
        return DisplayDirection.valueOf(direction.toString())
                .displayChar;
    }
}
