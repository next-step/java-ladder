package nextstep.refactor_ladder.ui;

import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.domain.LadderResults;
import nextstep.refactor_ladder.domain.Line;
import nextstep.refactor_ladder.domain.value.Direction;
import nextstep.refactor_ladder.domain.value.ExecutionResult;
import nextstep.refactor_ladder.domain.value.Person;

import java.util.List;

public class ResultView {
    private static final String BLANK = "     ";
    private static final String LADDER_LINE = "-----|";
    private static final String LADDER_BLANK = "     |";
    private static final String ENTER = "\r\n";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTION_RESULT = "실행결과";

    public void printLadder(List<Person> people, Ladder ladder, List<ExecutionResult> executionResults) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderBuilder.append(LADDER_RESULT).append(ENTER);

        printPeopleName(ladderBuilder, people);
        printLadder(ladderBuilder, ladder);
        printExecutionResult(ladderBuilder, executionResults);

        System.out.println(ladderBuilder.toString());
    }

    public void printResultOfLadder(LadderResults ladderResults, Person personName) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderBuilder.append(EXECUTION_RESULT).append(ENTER);

        ExecutionResult result = ladderResults.getLadderResult(personName);
        ladderBuilder.append(result.getResult()).append(ENTER);

        System.out.println(ladderBuilder.toString());
    }

    public void printResultOfAllLadder(LadderResults ladderResults) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderResults.getLadderResults().forEach((person, result) -> ladderBuilder
                .append(String.format("%s : %s ", person.getName(), result.getResult()))
                .append(ENTER));

        System.out.println(ladderBuilder.toString());
    }

    private void printPeopleName(StringBuilder ladderBuilder, List<Person> people) {
        ladderBuilder.append(BLANK);
        people.forEach(person -> ladderBuilder.append(String.format("%-5s ", person.getName())));
    }

    private void printLadder(StringBuilder ladderBuilder, Ladder ladder) {
        ladder.getLines().forEach(line -> {
            ladderBuilder.append(ENTER);
            printLine(ladderBuilder, line);
        });
    }

    private void printLine(StringBuilder ladderBuilder, Line line) {
        line.getPoints().forEach(point -> ladderBuilder.append(printDirection(point.direction)));
    }

    private String printDirection(Direction direction) {
        if (direction.isLeft()) {
            return LADDER_LINE;
        }
        return LADDER_BLANK;
    }

    private void printExecutionResult(StringBuilder ladderBuilder, List<ExecutionResult> executionResults) {
        ladderBuilder.append(ENTER);
        ladderBuilder.append(BLANK);
        executionResults.forEach(result -> ladderBuilder.append(String.format("%-5s ", result.getResult())));
    }
}
