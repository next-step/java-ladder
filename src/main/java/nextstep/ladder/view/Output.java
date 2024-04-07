package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.line.Point;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.NotExistUserException;

public class Output {

    private static final String HORIZONTAL_LINE = "-----|";
    private static final String EMPTY_SPACE = "     |";
    private static final String VERTICAL_LINE = "|";
    private static final String RESULT_HEADER = "사디리 결과";
    private static final String OUT_PUT_USER_FORMAT = "%6s";
    private static final String OUT_PUT_RESULT_FORMAT = "%-6s";


    private Output() {
    }

    public static void printLadderConsoleResult(Users users, Lines lines, List<String> result) {
        System.out.println(RESULT_HEADER);
        printUserNames(users);
        printLadderLines(lines);
        printLadderResult(result);
    }

    private static void printUserNames(Users users) {
        System.out.println();
        users.getUsers()
            .forEach(
                user -> System.out.print(String.format(OUT_PUT_USER_FORMAT, user.getUserName())));
        System.out.println();
    }

    private static void printLadderLines(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(String.format(OUT_PUT_USER_FORMAT, VERTICAL_LINE));
            printLineStatus(line);
            System.out.println();
        }
    }

    private static void printLineStatus(Line line) {
        for (Point status : line.getPoints()) {
            System.out.print(String.format(OUT_PUT_USER_FORMAT, status.isPointFalse()
                ? EMPTY_SPACE
                : HORIZONTAL_LINE));
        }
    }

    private static void printLadderResult(List<String> results) {
        results.forEach(result -> System.out.print(String.format(OUT_PUT_RESULT_FORMAT, result)));
        System.out.println();
    }

    public static boolean findAllDrawResult(LadderResult ladderResult, String userName) {
        if ("all".equals(userName)) {
            Output.printAllResult(ladderResult);
            return true;
        }
        return false;
    }

    public static void printAllResult(LadderResult ladderResult) {
        System.out.println("실행 결과");
        for (User user : ladderResult.keySet()) {
                System.out.println(String.format("%s : %s", user.getUserName(),
                    getDrawResult(ladderResult, user)));

        }
    }

    public static void printDrawResult(LadderResult ladderResult, User user) {
            System.out.println(getDrawResult(ladderResult, user));
    }

    private static String getDrawResult(LadderResult ladderResult, User user){
        return ladderResult.findUserDrawResult(user).getValue();
    }
}
