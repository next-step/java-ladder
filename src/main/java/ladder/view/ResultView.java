package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.domain.Line;
import ladder.domain.Point;

public class ResultView {
    private static final String OUTPUT_EXECUTION_RESULT = "실행결과";
    private static final String OUTPUT_LADDER_LINE_UNIT_SPACE = " ";
    private static final String OUTPUT_LADDER_LINE_UNIT_DASH = "-";
    private static final String OUTPUT_LADDER_LINE_UNIT_COLUMN = "|";
    private static final String DEFAULT_NAME_OUTPUT_FORMAT = "%6s";
    private static final int DEFAULT_LADDER_WIDTH = 5;

    private void outputName(String name) {
        System.out.printf(DEFAULT_NAME_OUTPUT_FORMAT, name);
    }

    private void outputNames(List<String> names) {
        names.forEach(this::outputName);
        System.out.print(System.lineSeparator());
    }

    private void outputLadderWidth(Point point) {
        StringBuilder stringBuilder = new StringBuilder();
        String lineUnit = OUTPUT_LADDER_LINE_UNIT_SPACE;
        if (point.existLeft()) {
            lineUnit = OUTPUT_LADDER_LINE_UNIT_DASH;
        }

        final String finalLineUnit = lineUnit;
        stringBuilder.append(IntStream.range(0, DEFAULT_LADDER_WIDTH)
            .mapToObj(e -> finalLineUnit)
            .collect(Collectors.joining(""))
        );
        stringBuilder.append(OUTPUT_LADDER_LINE_UNIT_COLUMN);
        System.out.print(stringBuilder);
    }

    private void outputLadderLine(Line line) {
        line.toList().forEach(this::outputLadderWidth);
        System.out.print(System.lineSeparator());
    }

    public void outputLadder(List<Line> lines, List<String> names) {
        outputExecutionResult();
        outputNames(names);
        lines.forEach(this::outputLadderLine);
    }

    private void outputExecutionResult() {
        System.out.print(System.lineSeparator());
        System.out.println(OUTPUT_EXECUTION_RESULT);
        System.out.print(System.lineSeparator());
    }
}
