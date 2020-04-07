package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;
import nextstep.ladder.dto.LadderRequestDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static final String NAME_FORMAT = "%6s";
    private static final String SPACE_FORMAT = "     ";
    private static final String LINE = "|";
    private static final String STEP = "-----";

    public static void printLadderGame(Ladder ladder, LadderRequestDto ladderRequestDto) {
        printPersons(ladder.getLines());
        printLines(ladder);
        printResults(ladderRequestDto);
        System.out.println();
    }

    private static void printResults(LadderRequestDto ladderRequestDto) {
        String results = Arrays.asList(ladderRequestDto.getResults().split(",")).stream()
                .map(result -> format(result))
                .collect(Collectors.joining());
        System.out.println(results);
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
        return String.format(NAME_FORMAT, name);
    }

    private static void printLines(Ladder ladder) {
        int heightOfLadder = ladder.getLines().get(0).getSteps().size();
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < heightOfLadder; i++) {
            printRows(lines, i);
        }
    }

    private static void printRows(List<Line> lines, int stepIndex) {
        int lineIndex = ZERO;
        System.out.print(SPACE_FORMAT);
        for (Line line : lines) {
            Steps steps = line.getSteps();
            System.out.print(printStep(lineIndex, steps.get(stepIndex)));
            lineIndex++;
        }
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static StringBuilder printStep(int lineIndex, Step step) {
        StringBuilder stringBuilder = new StringBuilder(LINE);
        if (step.isMovable(lineIndex + ONE)) {
            return stringBuilder.append(STEP);
        }
        return stringBuilder.append(SPACE_FORMAT);
    }


}
