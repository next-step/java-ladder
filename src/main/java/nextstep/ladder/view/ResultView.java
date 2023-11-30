package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String CONNECTION = "-----";
    private static final String DISCONNECTION = "     ";
    private static final String LEG = "|";

    private ResultView() {
    }

    public static void resultMessage() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printParticipantNames(List<Name> names) {
        System.out.println(names.stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining()));
    }

    public static void printResult(List<String> results) {
        System.out.println(results.stream()
                .map(result -> String.format("%6s", result))
                .collect(Collectors.joining()));
    }

    public static void printLadder(List<Line> ladder) {
        System.out.println(ladder.stream()
                .map(line -> disconnectionStep() + printLine(line.getLine()))
                .collect(Collectors.joining("\n")));
    }

    private static String printLine(List<Boolean> line) {
        return line.stream()
                .map(ResultView::makeStep)
                .collect(Collectors.joining());
    }

    private static String makeStep(boolean step) {
        if (step) {
            return connectionStep();
        }
        return disconnectionStep();
    }

    private static String connectionStep() {
        return CONNECTION + LEG;
    }

    private static String disconnectionStep() {
        return DISCONNECTION + LEG;
    }
}
