package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;
import nextstep.ladder.dto.LadderResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static final String NAME_FORMAT = "%6s";
    private static final String SPACE_FORMAT = "     ";
    private static final String LINE = "|";
    private static final String STEP = "-----";

    public static void printLadder(LadderResponseDto ladderResponseDto) {
        LadderGameInfo ladderGameInfo = ladderResponseDto.getLadderGameInfo();
        printPersons(ladderGameInfo.getPersons());
        printLines(ladderResponseDto.getLadder());
        printResult(ladderGameInfo.getResults());
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
        int heightOfLadder = ladder.getLadderLines().get(0).getSteps().size();
        List<LadderLine> ladderLines = ladder.getLadderLines();
        for (int i = 0; i < heightOfLadder; i++) {
            printRows(ladderLines, i);
        }
    }

    private static void printRows(List<LadderLine> ladderLines, int stepIndex) {
        int lineIndex = ZERO;
        System.out.print(SPACE_FORMAT);
        for (LadderLine ladderLine : ladderLines) {
            Steps steps = ladderLine.getSteps();
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

    public static void printOutput(List<Step> steps, List<String> names, LadderResponseDto ladderResponseDto) {
        System.out.println("실행결과");
        LadderGameInfo ladderGameInfo = ladderResponseDto.getLadderGameInfo();
        List<String> results = ladderGameInfo.getResults().stream()
                .map(Result::getResult)
                .collect(Collectors.toList());
        for (int i = 0; i < steps.size(); i++) {
            System.out.println(names.get(i) + " : " + results.get(steps.get(i).getLinePosition()));
        }
    }
}
