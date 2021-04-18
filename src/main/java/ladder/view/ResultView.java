package ladder.view;

import ladder.domain.*;

import java.util.stream.IntStream;

public final class ResultView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행결과";
    private static final String NAME_FORMAT = "%6s";
    private static final String LINE_FORMAT = "%6s";
    private static final String CROSS_LINE = "-----|";
    private static final String NORMAL_LINE = "     |";
    private static final String RESULT_FORMAT = "%s : %s\n";

    private static final int ZERO = 0;

    private static class ResultViewHolder {
        private static final ResultView instance = new ResultView();
    }

    private ResultView() {
    }

    public static final ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public final void printLadderStatus(People people, Ladder ladder, LadderResults results) {
        printExecutionResult();
        printPeopleName(people);
        printLadder(ladder);
        printResult(people, results);
    }

    private void printExecutionResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    private void printResult(People people, LadderResults results) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(ZERO, people.countOfPerson())
                .forEach(index -> stringBuilder.append(String.format(NAME_FORMAT, results.get(index))));
        System.out.println(stringBuilder);
    }

    private final void printLadder(Ladder ladder) {
        ladder.stream()
                .forEach(this::printLine);
    }

    private final void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        line.stream()
                .map(point -> point.hasPoint())
                .map(this::mapToLine)
                .forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }

    private final String mapToLine(Boolean lineResult) {
        if (lineResult) {
            return String.format(LINE_FORMAT, CROSS_LINE);
        }
        return String.format(LINE_FORMAT, NORMAL_LINE);
    }

    private final void printPeopleName(People people) {
        StringBuilder stringBuilder = new StringBuilder();
        people.stream()
                .map(Person::getName)
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }

    public final void printResult(Person person, LadderResultBoard ladderResultBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        String result = String.format(RESULT_FORMAT, person.getName(), ladderResultBoard.findResult(person));
        stringBuilder.append(result);
        System.out.println(stringBuilder);
    }

    public final void printResultAll(People people, LadderResultBoard ladderResultBoard) {
        printExecutionResult();
        StringBuilder stringBuilder = new StringBuilder();
        people.stream().forEach(person -> {
                    String result = String.format(RESULT_FORMAT, person.getName(), ladderResultBoard.findResult(person));
                    stringBuilder.append(result);
                }
        );
        System.out.println(stringBuilder);
    }

}
