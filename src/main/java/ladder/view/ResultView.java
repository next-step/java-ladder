package ladder.view;

import ladder.model.Line;
import ladder.model.Step;

import java.util.List;

public class ResultView {
    private static final String LADDER_PHRASE = "사다리 결과";
    private static final String RESUlT_PHRASE = "실행결과";
    private static final String NAME_FORMAT = "%6s";
    private static final String LADDER_FRONT_STRING = "   ";
    private static final String EMPTY_STEP_STRING = "     ";
    private static final String STEP_STRING = "-----";
    private static final String POINT_STRING = "|";
    private static final String RESULT_QUERY_FORMAT = "%s : %s";

    public static void printLadder(List<String> userNames, List<Line> lines, List<String> prizeNames) {
        printLadderResultPhrase();
        printLadderElements(userNames);
        printLadder(lines);
        printLadderElements(prizeNames);
    }

    private static void printLadderResultPhrase() {
        System.out.println(LADDER_PHRASE);
    }

    public static void printResultPhrase() {
        System.out.println(RESUlT_PHRASE);
    }

    private static void printLadderElements(List<String> elements) {
        elements.forEach(ResultView::printElement);
        System.out.println();
    }

    private static void printElement(String name) {
        System.out.printf(NAME_FORMAT, name);
    }

    private static void printLadder(List<Line> lines) {
        lines.forEach(line -> {
            printLine(line.getSteps());
            System.out.println();
        });
    }

    private static void printLine(List<Step> steps) {
        System.out.print(LADDER_FRONT_STRING);
        System.out.print(POINT_STRING);

        steps.stream()
                .limit(steps.size() - 1)
                .forEach(ResultView::printStep);
    }

    private static void printStep(Step step) {
        System.out.print(getStepString(step.hasRight()));
        System.out.print(POINT_STRING);
    }

    private static String getStepString(boolean hasStep) {
        return hasStep ? STEP_STRING : EMPTY_STEP_STRING;
    }

    public static void printResult(String userName, String prizeName) {
        System.out.println(String.format(RESULT_QUERY_FORMAT, userName, prizeName));
    }

}
