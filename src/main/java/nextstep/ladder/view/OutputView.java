package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.stream.Collectors;

public class OutputView {

    public static final String DIVIDER = "|";

    private OutputView() { }

    public static String drawLine(Line line, int maxUserNameLength) {
        return line.getPoints()
                .stream()
                .map(point -> PointRaw.getRawByIsPointExist(point, maxUserNameLength))
                .collect(Collectors.joining(DIVIDER, DIVIDER, DIVIDER));
    }

    public static void drawLadder(Ladder ladder, Users users) {
        String drawnLadder = ladder.getLines()
                .stream()
                .map(line -> drawLine(line, users.maxUserNameLength()))
                .collect(Collectors.joining("\n"));

        System.out.println(drawnLadder);
    }

    public static void drawUsers(Users users) {

    }
}
