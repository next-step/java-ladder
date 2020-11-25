package step02.view;

import step02.domain.Participants;
import step02.domain.Steps;

import java.util.List;

public class ResultView {
    private static final String RESULT = "실행결과";
    private static final String STEP = "|";
    private static final String LINE = "-----";
    private static final String EMPTY = "";
    private static final String NAME_SPACE = padLeft(EMPTY, 1);
    private static final String FIRST_BLANK = padLeft(EMPTY, 4);
    private static final String BLANK = padLeft(EMPTY, 5);

    private ResultView() {}

    private static String padLeft(String string, Integer repeat) {
        return String.format("%" + repeat + "s", string);
    }

    public static void print(Participants participants, Steps steps) {
        System.out.println(RESULT);
        printNamesOfParticipants(participants);
        printLadder(steps);
    }
    private static void printNamesOfParticipants(Participants participants) {
        participants.getNames()
                .forEach(name -> System.out.print(padLeft(name, 5) + NAME_SPACE));
        System.out.println();
    }

    private static void printLadder(Steps steps) {
        steps.getSteps()
                .forEach(step -> {
                    System.out.print(FIRST_BLANK + STEP);
                    printLine(step);
                    System.out.println();
                });
    }

    private static void printLine(List<Boolean> step) {
        step.forEach(point -> {
            String drawing = point ? LINE : BLANK;
            System.out.print(drawing + STEP);
        });
    }

}
