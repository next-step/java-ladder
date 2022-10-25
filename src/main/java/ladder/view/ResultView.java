package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String MSG_RESULT = "실행결과";
    public static final String LINE_EXIST = "|-----";
    public static final String LINE_NO_EXIST = "|     ";
    public static final String VERTICAL_LINE = "|";

    public static void printResult(Names names, Ladder ladder) {
        System.out.println(MSG_RESULT);
        printNames(names);
        printLadder(ladder);
    }

    private static void printNames(Names names) {
        for (Name name : names.getNames()) {
            System.out.print(String.format("%-6s", name.getName()));
        }
        System.out.println();

    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        List<String> resultLines = getResultLine(line);
        for (int i = 0; i < resultLines.size(); i++) {
            System.out.print(resultLines.get(i));
            printEndPoint(resultLines, i);
        }
        System.out.println();
    }

    private static List<String> getResultLine(Line line) {
        return line.getPoints().stream()
                .map(point -> getPointExist(point))
                .collect(Collectors.toList());
    }

    private static String getPointExist(Point point) {
        if (point.isExist()) return LINE_EXIST;
        return LINE_NO_EXIST;
    }

    private static void printEndPoint(List<String> points, int i) {
        if (i == points.size() - 1) {
            System.out.print(VERTICAL_LINE);
        }
    }

}
