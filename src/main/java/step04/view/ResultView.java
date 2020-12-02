package step04.view;

import step04.domain.*;

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

    private ResultView() {
    }

    private static String padLeft(String string, int repeat) {
        return String.format("%" + repeat + "s", string);
    }

    public static void printLadderWithNames(NamesOfParticipant namesOfParticipant, NamesOfResult namesOfResult, Ladder ladder) {
        System.out.println(LADDER_RESULT);
        printNames(namesOfParticipant.getNames());
        printLadder(ladder.getLadder());
        printNames(namesOfResult.getNames());
    }

    private static void printNames(List<Name> names) {
        names.forEach(name ->
                System.out.print(padLeft(name.toString(), 5) + NAME_SPACE)
        );
        System.out.println();
    }

    private static void printLadder(List<Step> ladder) {
        ladder.forEach(step -> {
            System.out.print(FIRST_BLANK + STEP);
            printSteps(step.getPoints());
            System.out.println();
        });
    }

    private static void printSteps(List<Point> step) {
        step.forEach(point -> {
            String drawing = point.hasLine() ? LINE : BLANK;
            System.out.print(drawing + STEP);
        });
    }

    public static void printResult(String nameOfResult) {
        System.out.println(EXECUTE_RESULT);
        System.out.println(nameOfResult);
    }

    public static void printResults(MatcherOfResult matcherOfResult) {
        System.out.println(EXECUTE_RESULT);

        Map<Name, Name> map = matcherOfResult.getResults();
        map.forEach((key, value) -> {
            System.out.printf(ALL_RESULTS, key.toString(), value.toString());
            System.out.println();
        });
    }

}
