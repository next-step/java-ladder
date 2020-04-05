package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLadder(Ladder ladder) {
        printPersons(ladder.getLines());
        printLines(ladder);
    }

    private static void printPersons(List<Line> lines) {
        String names = lines.stream()
                .map(Line::getPerson)
                .map(Person::getName)
                .map(name -> format(name))
                .collect(Collectors.joining());
        System.out.println(names);
    }

    private static String format(String name) {
        return String.format("%6s", name);
    }

    private static void printLines(Ladder ladder) {
        int heightOfLadder = ladder.getHeightOfLadder();
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < heightOfLadder; i++) {
            printRows(lines, i);
        }
    }

    private static void printRows(List<Line> lines, int stepIndex) {
        int lineIndex = 0;
        System.out.print("     ");
        for (Line line : lines) {
            Steps steps = line.getSteps();
            System.out.print(printStep(lineIndex, steps.get(stepIndex)));
            lineIndex++;
        }
        System.out.println();
    }

    private static StringBuilder printStep(int lineIndex, Step step) {
        StringBuilder stringBuilder = new StringBuilder("|");
        if (step.isMovableLine(lineIndex + 1)) {
            return stringBuilder.append("-----");
        }
        return stringBuilder.append("     ");
    }


}
