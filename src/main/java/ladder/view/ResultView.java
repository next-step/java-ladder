package ladder.view;

import ladder.model.LadderLine;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final int LADDER_WIDTH = 5;
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String ONE_BLANK_SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String LADDER_LONGITUDINAL_AXIS = "|";
    private static final String LADDER_HORIZONTAL_AXIS = "-";

    private static final PrintStream printStream = System.out;

    public static void printResultMessage() {
        printStream.println(RESULT_MESSAGE);
    }

    public static void printNewLine() {
        printStream.println();
    }

    public static void printResult(List<String> names, List<LadderLine> lines) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateNameResult(names));
        stringBuilder.append(NEW_LINE);

        for (LadderLine line : lines) {
            stringBuilder.append(generateLineResult(line));
            stringBuilder.append(NEW_LINE);
        }
        printStream.print(stringBuilder);
    }

    private static String generateNameResult(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        int blankSpaceLength;
        for (String name : names) {
            blankSpaceLength = LADDER_WIDTH - name.length();
            stringBuilder.append(generateBlankSpace(blankSpaceLength));
            stringBuilder.append(name);
            stringBuilder.append(ONE_BLANK_SPACE);
        }
        return stringBuilder.toString();
    }

    private static String generateBlankSpace(int blankSpaceLength) {
        return Stream.generate(() -> ONE_BLANK_SPACE)
                .limit(blankSpaceLength)
                .collect(joining());
    }

    private static String generateLineResult(LadderLine line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateBlankSpace(LADDER_WIDTH));
        stringBuilder.append(LADDER_LONGITUDINAL_AXIS);

        for (Boolean point : line.getPoints()) {
            stringBuilder.append(generatePointResult(point));
            stringBuilder.append(LADDER_LONGITUDINAL_AXIS);
        }
        return stringBuilder.toString();
    }

    private static String generatePointResult(Boolean point) {
        if (point) {
            return generateLadderHorizontalAxes();
        }
        return generateBlankSpace(LADDER_WIDTH);
    }

    private static String generateLadderHorizontalAxes() {
        return Stream.generate(() -> LADDER_HORIZONTAL_AXIS)
                .limit(LADDER_WIDTH)
                .collect(joining());
    }
}
