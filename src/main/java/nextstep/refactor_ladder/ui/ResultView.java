package nextstep.refactor_ladder.ui;

import nextstep.refactor_ladder.domain.Ladder;
import nextstep.refactor_ladder.domain.Line;
import nextstep.refactor_ladder.domain.value.Direction;

import java.util.List;

public class ResultView {
    private static final String BLANK = "     ";
    private static final String LADDER_LINE = "-----|";
    private static final String LADDER_BLANK = "     |";
    private static final String ENTER = "\r\n";
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTION_RESULT = "실행결과";

    public void printLadder(List<String> people, Ladder ladder, List<String> executionResults) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderBuilder.append(LADDER_RESULT).append(ENTER);

        printPeopleName(ladderBuilder, people);
        printLadder(ladderBuilder, ladder);
        printExecutionResult(ladderBuilder, executionResults);

        System.out.println(ladderBuilder.toString());
    }


    private void printPeopleName(StringBuilder ladderBuilder, List<String> people) {
        ladderBuilder.append(BLANK);
        people.forEach(person -> ladderBuilder.append(String.format("%-5s ", person)));
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

    private void printExecutionResult(StringBuilder ladderBuilder, List<String> executionResults) {
        ladderBuilder.append(ENTER);
        ladderBuilder.append(BLANK);
        executionResults.forEach(result -> ladderBuilder.append(String.format("%-5s ", result)));
    }
}
