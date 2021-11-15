package nextstep.ladder.ui;

import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.Line;
import nextstep.ladder.controller.People;

public class ResultView {
    private static final String BLANK = "     ";
    private static final String LADDER_PART1 = "-----|";
    private static final String LADDER_PART2 = "     |";
    private static final String ENTER = "\r\n";
    private static final String EXECUTION_RESULT = "실행결과";

    public void printLadder(People people, Ladder ladder) {
        StringBuilder ladderBuilder = new StringBuilder();
        ladderBuilder.append(EXECUTION_RESULT).append(ENTER);
        printPersonName(ladderBuilder, people);
        printLadder(ladderBuilder, ladder);

        System.out.println(ladderBuilder.toString());
    }

    private void printPersonName(StringBuilder ladderBuilder, People people) {
        ladderBuilder.append(BLANK);
        people.getPoints().forEach(person -> ladderBuilder.append(String.format("%-5s ", person.getName())));
    }

    private void printLadder(StringBuilder ladderBuilder, Ladder ladder) {
        for (Line line : ladder.getLines()) {
            ladderBuilder.append(ENTER);
            printLine(ladderBuilder, line);
        }
    }

    private void printLine(StringBuilder ladderBuilder, Line line) {
        line.getPoints().forEach(point -> {
            String result = point.isTrue() ? LADDER_PART1 : LADDER_PART2;
            ladderBuilder.append(result);
        });
    }
}
