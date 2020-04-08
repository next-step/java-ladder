package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DELIMITER = ",";

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static final String NAME_FORMAT = "%6s";
    private static final String SPACE_FORMAT = "     ";
    private static final String LINE = "|";
    private static final String STEP = "-----";

    public static void printLadder(LadderResponseDto ladderResponseDto) {
        printPersons(ladderResponseDto.getPersons());
        printLines(ladderResponseDto.getLadder());
        printResult(ladderResponseDto.getResults());
        System.out.println();
    }

    private static void printResult(List<Result> results) {
        String formatString = results.stream()
                .map(result -> format(result.getResult()))
                .collect(Collectors.joining());
        System.out.println(formatString);
    }

    private static void printPersons(List<Person> persons) {
        String names = persons.stream()
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

    public static void printOutput(Step result, LadderRequestDto ladderRequestDto) {
        String[] results = ladderRequestDto.getResults().split(DELIMITER);
        System.out.println("실행결과");
        System.out.println(results[result.getLinePosition()]);
    }

    public static void printAllOutput(List<Step> steps, LadderRequestDto ladderRequestDto) {
        String[] names = ladderRequestDto.getNames().split(DELIMITER);
        String[] results = ladderRequestDto.getResults().split(DELIMITER);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " : " + results[steps.get(i).getLinePosition()]);
        }
    }
}
