package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
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

    public static void printUserNames(List<UserName> userNames) {
        String names = userNames.stream()
                .map(userName -> String.format("%6s", userName.name()))
                .collect(Collectors.joining());
        System.out.println(names);
    }

    public static void printResultNames(String[] resultNames) {
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

    public static void printLadder(Lines lines) {
        lines.getLines().stream()
                .map(i -> printLine(i))
                .forEach(System.out::println);
    }

    private static String printLine(Line line) {
        String ladder = line.toList().stream()
                .map(l -> isLine(l))
                .collect(Collectors.joining(VERTICAL_LINE));

        return BLANK + VERTICAL_LINE + ladder + VERTICAL_LINE;
    }

    private static String isLine(boolean point) {
        if (point) {
            return HORIZONTAL_LINE;
        }
        return BLANK_HORIZONTAL_LINE;
    }

}
