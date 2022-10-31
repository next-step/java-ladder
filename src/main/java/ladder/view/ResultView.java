package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static final String MSG_LADDER_RESULT = "사다리 결과\n";
    public static final String MSG_EXECUTION_RESULT = "실행 결과";
    public static final String LINE_EXIST = "|-----";
    public static final String LINE_NO_EXIST = "|     ";
    public static final String VERTICAL_LINE = "|";
    public static final String RESULT_REGEX = ",";
    public static final String ALL_RESULT_REGEX = " : ";

    public static void printResult(Names names, Ladder ladder) {
        System.out.println(MSG_LADDER_RESULT);
        printNames(names);
        printLadder(ladder);
        System.out.println();
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

    public static void printLadderResult(String result) {
        System.out.println(MSG_EXECUTION_RESULT);
        System.out.println(result);
        System.out.println();
    }

    public static void printLadderResultAll(Map<Name, String> ladderResult) {
        System.out.println(MSG_EXECUTION_RESULT);
        ladderResult.forEach((name, result) -> System.out.println(name.getName() + ALL_RESULT_REGEX + result));
        System.out.println();
    }

}
