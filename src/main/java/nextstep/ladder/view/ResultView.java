package nextstep.ladder.view;

import nextstep.ladder.domain.Line;

import java.util.List;

public class ResultView {
    private static final String NAME_FORMAT = "%6s";

    public void printNames(List<String> names) {
        names.forEach(this::printName);
        System.out.println();
    }

    private void printName(String name) {
        System.out.printf(NAME_FORMAT, name);
    }

    public void printLadder(List<Line> lines) {
        lines.forEach(line -> {
            printLine(line.getSteps());
            System.out.println();
        });
    }

    private void printLine(List<Boolean> steps) {
        System.out.print("      ");
        System.out.print("|");
        steps.forEach(step -> {
            System.out.print(step ? "-----" : "     ");
            System.out.print("|");
        });
    }
}
