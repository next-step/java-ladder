package nextstep.ladder.ui;

import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.Line;
import nextstep.ladder.doamin.value.Person;

import java.util.List;

public class ResultView {
    private static final String BLANK = "     ";
    private static final String LADDER_PART1 = "-----|";
    private static final String LADDER_PART2 = "     |";
    private static final String ENTER = "\r\n";
    private static final String EXECUTION_RESULT = "실행결과";

    public void printLadder(List<Person> people, Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append(EXECUTION_RESULT).append(ENTER);
        printPersonName(sb, people);
        printLadder(sb, ladder);

        System.out.println(sb.toString());
    }

    private void printPersonName(StringBuilder sb, List<Person> people) {
        sb.append(BLANK);
        people.forEach(person -> sb.append(String.format("%-5s ", person.getName())));
    }

    private void printLadder(StringBuilder sb, Ladder ladder) {
        for (Line line : ladder.getLines()) {
            sb.append(ENTER);
            line.getPoints().forEach(point -> printLadder(sb, point));
        }
    }

    private void printLadder(StringBuilder sb, boolean point) {
        if (!point) {
            sb.append(LADDER_PART2);
            return;
        }
        sb.append(LADDER_PART1);
    }
}
