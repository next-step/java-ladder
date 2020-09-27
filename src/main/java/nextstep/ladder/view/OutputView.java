package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.util.Utils;

import java.util.stream.Collectors;

public class OutputView {

    public static final String DIVIDER = "|";

    private OutputView() { }

    public static String drawLine(Line line, int maxUserNameLength) {
        return line.getLegs()
                .stream()
                .map(point -> PointRaw.getRawByIsPointExist(point, maxUserNameLength))
                .collect(Collectors.joining(DIVIDER, DIVIDER, DIVIDER));
    }

    public static void drawLadderGame(Ladder ladder, Users users, Result result) {
        drawUsers(users);
        drawLadder(ladder, users);

        drawResult(result, users);
    }

    private static void drawUsers(Users users) {
        String drawnUsers = users.getUsers()
                .stream()
                .map(User::getName)
                .map(e -> String.format(" %-"+users.getMaxUserNameLength()+"s", e))
                .collect(Collectors.joining(""));

        System.out.println(drawnUsers);
    }

    private static void drawLadder(Ladder ladder, Users users) {
        String drawnLadder = ladder.getLines()
                .stream()
                .map(line -> drawLine(line, users.getMaxUserNameLength()))
                .collect(Collectors.joining("\n"));

        System.out.println(drawnLadder);
    }

    private static void drawResult(Result result, Users users) {
        String collect = result.getResult()
                .stream()
                .map(e -> String.format(" %-"+users.getMaxUserNameLength()+"s", e))
                .collect(Collectors.joining(""));
        System.out.println(collect);
    }
}
