package nextstep.ladder.ui;

import nextstep.ladder.doamin.*;
import nextstep.ladder.doamin.value.Person;

public class ResultView {
    private static final String BLANK = "     ";
    private static final String LADDER_PART1 = "-----|";
    private static final String LADDER_PART2 = "     |";
    private static final String ENTER = "\r\n";
    private static final String EXECUTION_RESULT = "실행결과";

    public void printLadder(LadderResult ladderResult) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderBuilder.append(EXECUTION_RESULT).append(ENTER);

        printPersonName(ladderBuilder, ladderResult.getPeople());
        printLadder(ladderBuilder, ladderResult.getLadder());
        printExecutionResult(ladderBuilder, ladderResult.getExecutionResult());

        System.out.println(ladderBuilder.toString());
    }

    public void printLadderResult(LadderResult ladderResult, Person personName) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderBuilder.append(EXECUTION_RESULT).append(ENTER);

        if (personName.isAll()) {
            ladderResult.getPeople().getPersonList().forEach(person -> {
                String result = ladderResult.getLadderResult(person);
                ladderBuilder.append(String.format("%s : %s ", person.getName(), result)).append(ENTER);
            });
        }

        if (!personName.isAll()) {
            String result = ladderResult.getLadderResult(personName);
            ladderBuilder.append(result).append(ENTER);
        }

        System.out.println(ladderBuilder.toString());
    }

    private void printPersonName(StringBuilder ladderBuilder, People people) {
        ladderBuilder.append(BLANK);
        people.getPersonList().forEach(person -> ladderBuilder.append(String.format("%-5s ", person.getName())));
    }

    private void printLadder(StringBuilder ladderBuilder, Ladder ladder) {
        ladder.getLines().forEach(line -> {
            ladderBuilder.append(ENTER);
            printLine(ladderBuilder, line);
        });
    }

    private void printLine(StringBuilder ladderBuilder, Line line) {
        line.getPoints().forEach(point -> {
            String result = point.isTrue() ? LADDER_PART1 : LADDER_PART2;
            ladderBuilder.append(result);
        });
    }

    private void printExecutionResult(StringBuilder ladderBuilder, ExecutionResult executionResult) {
        ladderBuilder.append(ENTER);
        ladderBuilder.append(BLANK);
        executionResult.getExecutionResults().forEach(result -> ladderBuilder.append(String.format("%-5s ", result)));
    }
}
