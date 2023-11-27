package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;

import java.util.List;

public class ResultView {
    private static final String CONNECTION = "-----";
    private static final String DISCONNECTION = "     ";
    private static final String LEG = "|";
    private ResultView() {
    }

    public static void resultMessage() {
        System.out.print("실행결과");
    }

    public static void printParticipantNames(List<Name> names) {
        names.stream().forEach(name -> System.out.print(String.format("%6s", name)));
        System.out.println();
    }
    public static void printLadder(List<Line> ladder) {
        ladder.stream().forEach(line -> {
            System.out.print(disconnectionStep());
            printLine(line.getLine());
        });
    }
    private static void printLine(List<Boolean> line) {
        StringBuffer lineDisplay = new StringBuffer();
        line.stream()
                .forEach(flag -> lineDisplay.append(makeStep(flag)));
        System.out.println(lineDisplay);
    }

    private static String makeStep(boolean step) {
        if (step) {
            return connectionStep();
        }
        return disconnectionStep();
    }

    private static String connectionStep() {
        return CONNECTION+LEG;
    }

    private static String disconnectionStep() {
        return DISCONNECTION+LEG;
    }
}
