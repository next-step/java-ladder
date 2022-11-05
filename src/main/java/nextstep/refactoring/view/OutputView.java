package nextstep.refactoring.view;

import nextstep.refactoring.*;
import nextstep.refactoring.user.User;
import nextstep.refactoring.user.Users;

import java.util.List;

public class OutputView {
    private static final int MINIMUM_SIZE = User.NAME_MAX_LENGTH;
    private static final String LINE_SPACE = Shape.BLANK.makePrintShape(MINIMUM_SIZE);
    private static final String NAME_FORMAT = "%" + MINIMUM_SIZE + "s";
    private static final String NEW_LINE = "\n";
    private static final String ALL = "all";

    private OutputView() {
    }

    public static void printLadderResultSentence() {
        System.out.println("사다리 결과" + NEW_LINE);
    }

    public static void printUsernames(Users users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users.getUsers()) {
            sb.append(String.format(NAME_FORMAT, user.getName())).append(Shape.BLANK.makePrintShape(1));
        }
        System.out.println(sb);

    }

    public static void printResult(List<String> results) {
        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(String.format(NAME_FORMAT, result)).append(Shape.BLANK.makePrintShape(1));
        }
        System.out.println(sb);
    }

    public static void printLadder(Lines lines) {
        StringBuilder sb = new StringBuilder();
        List<Line> lineList = lines.getLines();
        for (Line line : lineList) {
            sb.append(LINE_SPACE);
            List<Position> positions = line.getPositions().getPositions();
            addOneLine(sb, positions);
        }
        System.out.print(sb);
    }

    private static void addOneLine(StringBuilder sb, List<Position> positions) {
        for (Position position : positions) {
            sb.append(Shape.VERTICAL_LINE.makePrintShape(1));
            Spot spot = position.getSpot();
            addBridge(sb, spot);
        }
        sb.append(NEW_LINE);
    }

    private static void addBridge(StringBuilder sb, Spot spot) {
        if (spot.isRight()) {
            sb.append(Shape.HORIZONTAL_LINE.makePrintShape(MINIMUM_SIZE));
            return ;
        }
        sb.append(LINE_SPACE);
    }

    public static void printExecuteResultSentence() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void printGameResult(Users users, User inputUser, List<LadderResult> ladderResults, List<String> executeResult) {
        int index = findIndexOfUser(inputUser, users);
        LadderResult ladderResult = ladderResults.get(index);
        System.out.println(executeResult.get(ladderResult.getEndIndex()));
    }

    private static int findIndexOfUser(User inputUser, Users users) {
        return users.findIndexOfUser(inputUser);
    }

    public static void printAllResult(Users users, List<LadderResult> ladderResults, List<String> executeResult) {
        StringBuilder sb = new StringBuilder();
        List<User> userList = users.getUsers();
        for (User user : userList) {
            sb.append(user.getName()).append(" : ").append(executeResult.get(ladderResults.get(findIndexOfUser(user, users)).getEndIndex()));
            sb.append(NEW_LINE);
        }
        System.out.println(sb);
    }
}
