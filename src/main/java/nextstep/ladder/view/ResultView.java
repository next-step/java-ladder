package nextstep.ladder.view;

import static nextstep.ladder.view.ViewConstant.CONNECTED_LINE;
import static nextstep.ladder.view.ViewConstant.LINE_BLANK;
import static nextstep.ladder.view.ViewConstant.NAME_BLANK;
import static nextstep.ladder.view.ViewConstant.NEW_LINE;
import static nextstep.ladder.view.ViewConstant.OUTPUT_RESULT;
import static nextstep.ladder.view.ViewConstant.VERTICAL_BAR;

import java.util.stream.Collectors;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.user.Users;

public class ResultView {

    public static void printMessage(String msg) {
        System.out.print(msg);
    }

    public static void printCreatedLadder(Users users, Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_RESULT).append(NEW_LINE);

        users.getUserNames().forEach(name -> sb.append(name).append(NAME_BLANK));
        sb.append(NEW_LINE);
        sb.append(printLadder(ladder));

        printMessage(sb.toString());
    }

    private static String printLadder(Ladder ladder) {
        return ladder.getLines().stream()
            .map(ResultView::printLine)
            .collect(Collectors.joining(NEW_LINE));
    }

    private static String printLine(Line line) {
        return line.getPoints().stream()
            .map(point -> point.isConnected() ? CONNECTED_LINE : LINE_BLANK)
            .collect(Collectors.joining(VERTICAL_BAR, LINE_BLANK + VERTICAL_BAR, VERTICAL_BAR));
    }


}
