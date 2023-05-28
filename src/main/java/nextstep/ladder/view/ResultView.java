package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.ResultMap;
import nextstep.ladder.domain.UserName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String BLANK = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String BLANK_HORIZONTAL_LINE = "     ";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLadder(List<UserName> userNames, Lines ladder, String[] results) {
        printUserNames(userNames);
        printLadder(ladder);
        printResultNames(results);
    }

    private static void printUserNames(List<UserName> userNames) {
        String names = userNames.stream()
                .map(userName -> String.format("%6s", userName.name()))
                .collect(Collectors.joining());
        System.out.println(names);
    }

    private static void printResultNames(String[] resultNames) {
        String names = Arrays.stream(resultNames)
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
        System.out.println(names);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printBlankLine() {
        System.out.println();
    }

    private static void printLadder(Lines lines) {
        lines.getLines().stream()
                .map(i -> printLine(i))
                .forEach(System.out::println);
    }

    private static String printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Boolean> points = line.toList();

        stringBuilder.append(BLANK);
        for (int i = 0; i < points.size() - 1; i++) {
            stringBuilder.append(VERTICAL_LINE + isLine(points.get(i)));
        }

        stringBuilder.append(VERTICAL_LINE);
        return stringBuilder.toString();
    }

    private static String isLine(boolean point) {
        if (point) {
            return HORIZONTAL_LINE;
        }
        return BLANK_HORIZONTAL_LINE;
    }

    public static void printResult(List<UserName> userNames, ResultMap resultMap) {
        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            String name = InputView.readString();

            System.out.println();
            if (getResultWithName(userNames, resultMap, name)) break;
            System.out.println();
        }
    }

    private static boolean getResultWithName(List<UserName> userNames, ResultMap resultMap, String name) {
        System.out.println("실행결과");
        if ("all".equals(name)) {
            userNames.stream()
                    .forEach(userName -> {
                        System.out.println(userName.name() + " : " + resultMap.getResult(userName.name()));
                    });
            return true;
        }
        System.out.println(name + " : " + resultMap.getResult(name));
        return false;
    }
}
