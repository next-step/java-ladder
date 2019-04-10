package view;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.Pair;
import domain.user.User;
import domain.user.Users;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class ResultView {
    private static final String BRIDGE = "-";
    private static final String LADDER = "|";
    private static final String SPACE = " ";

    public static void result(Users users, Ladder ladder) {
        printUsers(users);
        printLadder(ladder);
    }

    private static void printUsers(Users users) {
        List<User> userNames = users.getUsers();
        for (User name : userNames) {
            System.out.print(formatter(SPACE, name.toString()));
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLadder();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<Pair> pairs = line.getPairs();
        String lineView = "";
        for (Pair pair : pairs) {
            lineView += printPair(pair);
        }
        System.out.println(lineView);
    }

    private static String printPair(Pair pair) {
        String pairView = "";
        if (pair.isLeft()) {
            pairView += StringUtils.repeat(BRIDGE, Users.MARGIN);
            pairView += LADDER;
            return pairView;
        }

        pairView += StringUtils.repeat(SPACE, Users.MARGIN);
        pairView += LADDER;
        return pairView;
    }

    private static String formatter(String repeatPattern, String parameter) {
        return StringUtils.repeat(repeatPattern, Users.MARGIN - parameter.length() + 1) + parameter;
    }
}
