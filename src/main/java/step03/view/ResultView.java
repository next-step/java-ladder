package step03.view;

import step03.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String EXECUTE_RESULT = "실행결과";
    private static final String LADDER_RESULT = "사다리결과";
    private static final String STEP = "|";
    private static final String LINE = "-----";
    private static final String EMPTY = "";
    private static final String NAME_SPACE = padLeft(EMPTY, 1);
    private static final String FIRST_BLANK = padLeft(EMPTY, 4);
    private static final String BLANK = padLeft(EMPTY, 5);
    private static final String ALL_RESULTS = "%s : %s";

    private ResultView() {}

    private static String padLeft(String string, Integer repeat) {
        return String.format("%" + repeat + "s", string);
    }

    public static void printLadderWithNames(Participants participants, NamesOfResult namesOfResult, List<List<Boolean>> ladder) {
        System.out.println(LADDER_RESULT);
        printNames(participants.getNames());
        printLadder(ladder);
        printNames(namesOfResult.getNames());
    }
    private static void printNames(List<String> names) {
        names.forEach(name -> System.out.print(padLeft(name, 5) + NAME_SPACE));
        System.out.println();
    }

    private static void printLadder(List<List<Boolean>> ladder) {
        ladder.forEach(step -> {
                    System.out.print(FIRST_BLANK + STEP);
                    printSteps(step);
                    System.out.println();
                });
    }

    private static void printSteps(List<Boolean> step) {
        step.forEach(point -> {
            String drawing = point ? LINE : BLANK;
            System.out.print(drawing + STEP);
        });
    }

    public static void printResult(String nameOfResult) {
        System.out.println(EXECUTE_RESULT);
        System.out.println(nameOfResult);
    }

    public static void printResults(Matcher matcher) {
        System.out.println(EXECUTE_RESULT);

        Map<String, String> map = matcher.getResults();
        map.forEach((key, value) -> {
            System.out.printf(ALL_RESULTS, key, value);
            System.out.println();
        });
    }

}
