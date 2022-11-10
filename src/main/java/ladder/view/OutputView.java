package ladder.view;


import ladder.domain.Line;
import ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String BLANK = " ";
    public static final int LINE_LENGTH_MAX = 5;
    public static final String LADDER_SHAPE = "|";
    public static final String LINE = "-";

    private OutputView() {
    }

    public static void printLadder(List<User> userList, List<Line> lines)
    {
        System.out.println("실행결과");
        printUser(userList);
        printLine(lines);
    }

    private static void printLine(List<Line> lines)
    {
        lines.forEach(line -> {
                System.out.print("\n" + BLANK.repeat(3));
                printLines(line.getPoints());
                System.out.print(LADDER_SHAPE);
            });
    }

    private static void printLines(List<Boolean> points) {
        points.stream()
            .forEach(point -> {
                System.out.print(LADDER_SHAPE);
                System.out.print(getLine(point));
            });
    }

    private static String getLine(boolean isLine) {
        if (isLine) {
            return LINE.repeat(LINE_LENGTH_MAX);
        }
        return BLANK.repeat(LINE_LENGTH_MAX);
    }


    private static void printUser(List<User> userList) {
        System.out.println(userList.stream()
            .map(User::getName)
            .map(OutputView::outputPersonName)
            .collect(Collectors.joining(BLANK)));
    }

    private static String outputPersonName(String name) {
        if (name.length() < LINE_LENGTH_MAX) {
            return String.format("%4s ", name);
        }
        return name;
    }
}
