package ladder.ui;

import java.util.stream.Collectors;
import ladder.domain.ladder.Ladder;
import ladder.domain.point.Point;
import ladder.domain.user.User;
import ladder.domain.user.Users;

public class OutputView {

    private static final String CONSTRUCTION_RESULT_MESSAGE = "실행결과";
    private static final String FIVE_LENGTH_SPACE = "     ";
    private static final String FIVE_LENGTH_HYPHEN = "-----";
    private static final String POINT_INDICATOR = "|";
    private static final int NAME_START_INDEX = 0;

    private OutputView() {}

    public static void printConstructedGame(Users users, Ladder ladder) {
        System.out.println(CONSTRUCTION_RESULT_MESSAGE);
        printUsersNames(users);
        printLadder(ladder);

    }

    private static void printUsersNames(Users users) {
        String participantsNames = users.getUsers()
            .stream()
            .map(User::getName)
            .map(OutputView::padToSameLength)
            .collect(Collectors.joining(" "));
        System.out.println(participantsNames);
    }

    private static void printLadder(Ladder ladder) {
        String ladderShape = ladder.getLines()
            .stream()
            .map(line -> line.getPoints().stream()
                .map(OutputView::transformPointToString)
                .collect(Collectors.joining())
            )
            .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(ladderShape);
    }

    private static String transformPointToString(Point point) {
        return POINT_INDICATOR + appendSymbol(point);
    }

    private static String appendSymbol(Point point) {
        if (point.isRightDirection()) {
            return FIVE_LENGTH_HYPHEN;
        }
        return FIVE_LENGTH_SPACE;
    }

    private static String padToSameLength(String name) {
        StringBuilder stringBuilder = new StringBuilder(FIVE_LENGTH_SPACE);
        stringBuilder.replace(NAME_START_INDEX, name.length(), name);
        return stringBuilder.toString();
    }
}
