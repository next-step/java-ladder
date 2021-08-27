package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String OUTPUT_EXECUTION_RESULT = "실행결과";
    private static final String OUTPUT_LADDER_RESULT = "사다리 결과";
    private static final String OUTPUT_LADDER_LINE_UNIT_SPACE = " ";
    private static final String OUTPUT_LADDER_LINE_UNIT_DASH = "-";
    private static final String OUTPUT_LADDER_LINE_UNIT_COLUMN = "|";
    private static final String DEFAULT_NAME_OUTPUT_FORMAT = "%6s";
    private static final String DEFAULT_RESULT_OUTPUT_FORMAT = "%6s";
    private static final int DEFAULT_LADDER_WIDTH = 5;

    private void outputName(String name) {
        System.out.printf(DEFAULT_NAME_OUTPUT_FORMAT, name);
    }

    private void outputNames(List<String> names) {
        names.forEach(this::outputName);
        System.out.print(System.lineSeparator());
    }

    private void outputResult(String result) {
        System.out.printf(DEFAULT_RESULT_OUTPUT_FORMAT, result);
    }

    private void outputResults(List<String> results) {
        results.forEach(this::outputResult);
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

    public void outputLadder(ExecutionResults executionResults, List<Line> lines) {
        outputLadderResult();
        outputNames(executionResults.toNameStringList());
        lines.forEach(this::outputLadderLine);
        outputResults(executionResults.toResultStringList());
    }

    private void outputLadderResult() {
        System.out.print(System.lineSeparator());
        System.out.println(OUTPUT_LADDER_RESULT);
        System.out.print(System.lineSeparator());
    }

    public void outputExecutionResult() {
        System.out.print(System.lineSeparator());
        System.out.println(OUTPUT_EXECUTION_RESULT);
    }

    public void outputAskResultAll(final Ladder ladder, final ExecutionResults executionResults) {
        List<String> names = executionResults.toNameStringList();
        List<String> results = executionResults.toResultStringList();

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s : %s\n", names.get(i), results.get(ladder.resultIndexOf(Index.from(i))));
        }
    }

    public void outputAskResultOne(final ExecutionResults executionResults, int index) {
        System.out.printf("%s", executionResults.toResultStringList().get(index));
        System.out.print(System.lineSeparator());
    }
}
