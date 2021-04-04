package nextstep.ladder.views;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.utils.StringUtils;

import java.util.stream.Collectors;

public class ResultView {
    private final static int DISPLAY_BLANK_LENGTH = 5;
    private final static String ENTER = "\n";

    public static void showLadder(GameResult result) {
        String stringBuilder = "실행 결과" +
                "\n" +
                result.playersNames() +
                "\n" +
                getLadder(result.ladder());
        System.out.println(stringBuilder);
    }

    public static String getLadder(Ladder ladder) {
        return ladder.lines()
                .stream()
                .map(ResultView::getLine)
                .collect(Collectors.joining(ENTER));
    }

    public static String getLine(Line line) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH)
                + line.points()
                .stream()
                .map(point -> point.nextDirection().displayChar)
                .collect(Collectors.joining());
    }
}
