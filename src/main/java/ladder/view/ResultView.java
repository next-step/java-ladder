package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.domain.ExecutionResults;
import ladder.domain.Index;
import ladder.domain.Ladder;
import ladder.domain.LadderLine;

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

    private void outputLadderWidth(boolean isLeft) {
        StringBuilder stringBuilder = new StringBuilder();
        String lineUnit = OUTPUT_LADDER_LINE_UNIT_SPACE;
        if (isLeft) {
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

    private void outputLadderLine(LadderLine ladderLine) {
        IntStream.range(0, ladderLine.toList().size())
            .forEach(i -> outputLadderWidth(ladderLine.move(i) < i));
        System.out.print(System.lineSeparator());
    }

    public void outputLadder(ExecutionResults executionResults, List<LadderLine> ladderLines) {
        outputLadderResult();
        outputNames(executionResults.toNameStringList());
        ladderLines.forEach(this::outputLadderLine);
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
