package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderResultBoard;
import ladder.domain.ladder.LadderResults;
import ladder.domain.ladder.Line;
import ladder.domain.participant.People;
import ladder.domain.participant.Person;

import java.util.stream.IntStream;

public final class ResultView {

    private static final String EXECUTION_RESULT_MESSAGE = "\n실행결과";
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

    public final void printExecutionResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public final void printLadder(Ladder ladder) {
        ladder.stream().forEach(this::printLine);
    }

    public final void printPeople(People people) {
        printPeopleName(people);
    }

    public final void printLadderResult(LadderResults results) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(ZERO, results.size())
                .forEach(index -> stringBuilder.append(String.format(NAME_FORMAT, results.get(index))));
        System.out.println(stringBuilder);
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
                .map(Person::name)
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(stringBuilder::append);
        System.out.println(stringBuilder);
    }

    public final void printLadderGameResult(Person person, LadderResultBoard ladderResultBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        String result = String.format(RESULT_FORMAT, person.name(), ladderResultBoard.findResultByPerson(person));
        stringBuilder.append(result);
        System.out.println(stringBuilder);
    }

    public final void printLadderGameResultAll(People people, LadderResultBoard ladderResultBoard) {
        printExecutionResult();
        StringBuilder stringBuilder = new StringBuilder();
        people.stream().forEach(person -> {
                    String result = String.format(RESULT_FORMAT, person.name(), ladderResultBoard.findResultByPerson(person));
                    stringBuilder.append(result);
                }
        );
        System.out.println(stringBuilder);
    }

}
