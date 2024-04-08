package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.result.LadderResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final static String LINE_SEPARATOR = System.lineSeparator();
    private final static String RESULT_MESSAGE = "실행결과";
    private final static String BLANK = "     ";
    private final static String CONNECT_LINE = "-----";
    private final static String STRIPE = "|";

    public static void viewResult(LadderResult ladderResult) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(RESULT_MESSAGE)
                .append(LINE_SEPARATOR)
                .append(LINE_SEPARATOR);


        //print usernames
        List<String> userNames = ladderResult.getUserNames();
        for (String userName : userNames) {
            stringBuilder.append(userName).append(BLANK);
        }

        stringBuilder.append(LINE_SEPARATOR);

        //print ladder
        Ladder ladder = ladderResult.getLadder();
        stringBuilder.append(printLadder(ladder));

        System.out.println(stringBuilder);
    }

    private static String printLadder(Ladder ladder) {
        return ladder.getLines().stream()
                .map(line -> printLine(line))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private static String printLine(Line line) {
        return line.getPoints().stream()
                .map(point -> printPoint(point))
                .collect(Collectors.joining(STRIPE, BLANK + STRIPE, STRIPE));
    }

    private static String printPoint(Point point) {
        return point.isConnect() ? CONNECT_LINE : BLANK;
    }
}
