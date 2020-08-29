package ladder.view;

import ladder.model.Line;

import java.util.List;

public class ResultView {
    private static final String RESUlT_PHRASE = "실행결과";
    private static final String NAME_FORMAT = "%6s";
    private static final String LADDER_FRONT_STRING = "   ";
    private static final String EMPTY_STEP_STRING = "     ";
    private static final String STEP_STRING = "-----";
    private static final String POINT_STRING = "|";


    public void printResultPhrase() {
        System.out.println(RESUlT_PHRASE);
    }

    public void printUserNames(List<String> userNames) {
        userNames.forEach(this::printUserName);
        System.out.println();
    }

    private void printUserName(String name) {
        System.out.printf(NAME_FORMAT, name);
    }

    public void printLadder(List<Line> lines) {
        lines.forEach(line -> {
            printLine(line.getSteps());
            System.out.println();
        });
    }

    private void printLine(List<Boolean> steps) {
        System.out.print(LADDER_FRONT_STRING);
        System.out.print(POINT_STRING);

        steps.forEach(step -> {
            System.out.print(getStepString(step));
            System.out.print(POINT_STRING);
        });
    }

    private String getStepString(boolean hasStep) {
        return hasStep ? STEP_STRING : EMPTY_STEP_STRING;
    }

}
