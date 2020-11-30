package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String RESULT_EXECUTE_MESSAGE = "\n실행결과\n\n";

    private ResultView() {}

    public static void printGameResult(Users users, Lines lines) {
        System.out.print(RESULT_EXECUTE_MESSAGE);
        printGamePlayers(users);
        printLadderGame(lines);
    }

    private static void printGamePlayers(Users users) {
        List<User> userList = users.getUsers();
        userList.forEach(e -> System.out.print(getPlayer(e.getUserName()) + " "));
        System.out.println();
    }

    private static String getPlayer(String name) {
        if (name.length() == MAX_NAME_LENGTH) {
            return name;
        }
        return String.format("%-"+MAX_NAME_LENGTH+"s",name);
    }

    private static void printLadderGame(Lines lines) {
        List<Line> lineList = lines.getLines();
        IntStream.range(0,lineList.size())
                .forEach(i -> printLine(lineList.get(i)));
    }

    private static void printLine(Line line) {
        List<Boolean> booleans = line.getPoints();
        System.out.print("    ");
        IntStream.range(0,booleans.size())
                .filter(i -> i != booleans.size())
                .forEach(i -> parseBooleanToString(line.hasRightMoved(i)));
        System.out.println();
    }

    private static void parseBooleanToString(boolean moved) {
        if (moved) {
            System.out.print("|-----");
            return;
        }
        System.out.print("|     ");
    }
}
