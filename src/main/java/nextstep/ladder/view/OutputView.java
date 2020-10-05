package nextstep.ladder.view;

import nextstep.ladder.domain.*;

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

    public static void drawLadderGame(Ladder ladder) {
        drawUsers(ladder.getUsers(), ladder.getMaxUserNameLength());
        drawLadder(ladder.getLines(), ladder.getMaxUserNameLength());
        drawResult(ladder.getResults(), ladder.getMaxUserNameLength());
    }

    private static void drawUsers(Users users, int maxUserNameLength) {
        String drawnUsers = users.getUsers()
                .stream()
                .map(User::getName)
                .map(e -> String.format(" %-"+users.getMaxUserNameLength()+"s", e))
                .collect(Collectors.joining(""));

        System.out.println(drawnUsers);
    }

    private static void drawLadder(Lines lines, int maxUserNameLength) {
        String drawnLadder = lines
                .getLines()
                .stream()
                .map(line -> drawLine(line, maxUserNameLength))
                .collect(Collectors.joining("\n"));

        System.out.println(drawnLadder);
    }

    private static void drawResult(Results result, int maxUserNameLength) {
        String collect = result.getResultNames()
                .stream()
                .map(e -> String.format(" %-"+maxUserNameLength+"s", e))
                .collect(Collectors.joining(""));
        System.out.println(collect);
    }

    public static void printResult(String username, Ladder ladder) {
        if (username.equalsIgnoreCase("ALL")) {
            printAllResult(ladder);
            return;
        }
        String result = ladder.getResultByUsername(username);
        System.out.println(result);
    }

    private static void printAllResult(Ladder ladder) {
        Results resultsOfUsers = ladder.getResultsOfUsers();
        resultsOfUsers.getResults()
                .forEach(result -> {
                    System.out.println(String.format("%s : %s", result.getUsername(), result.getResultName()));
                });
    }
}
