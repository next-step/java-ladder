package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RESULT_EXECUTE_MESSAGE = "실행결과";
    private static final String LINE_FULL = "|-----";
    private static final String LINE_EMPTY = "|     ";


    private ResultView() {}

    public static void printGameResult(Users users, Lines lines) {
        System.out.println(LINE_SEPARATOR + RESULT_EXECUTE_MESSAGE + LINE_SEPARATOR);
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
        return String.format("%-" + MAX_NAME_LENGTH + "s",name);
    }

    private static void printLadderGame(Lines lines) {
        List<Line> lineList = lines.getLines();
        IntStream.range(0,lineList.size())
                .forEach(i -> printLine(lineList.get(i)));
    }

    private static void printLine(Line line) {
        System.out.print("    ");
        parseBooleanToString(line.getPoints());
        System.out.println();
    }

    private static void parseBooleanToString(List<Point> points) {
        StringBuilder ladderLine = new StringBuilder();
        points.stream()
                .map(point -> hasLine(point.isMovable()))
                .forEach(ladderLine::append);
        System.out.print(ladderLine.toString());
    }

    private static String hasLine(boolean hasLine) {
        if (hasLine) {
           return LINE_FULL;
        }
        return LINE_EMPTY;
    }
}
