package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Point;

import java.util.List;

public class ResultView {
    private static final int LADDER_POINT_COUNT = 5;

    public static void printLadder(List<Person> people, Ladder ladder) {
        System.out.print("\n실행결과\n\n");
        people.forEach(person -> System.out.printf("%6s", person.getName()));

        System.out.println();
        ladder.getLines().forEach(line -> {
            System.out.print(" ".repeat(LADDER_POINT_COUNT) + "|");
            printLadderLine(line);
            System.out.println();
        });
    }

    private static void printLadderLine(Line line) {
        line.getPoints().forEach(ResultView::printLadderPoint);
    }

    private static void printLadderPoint(Point point) {
        System.out.print((point.getValue() ? "-" : " ").repeat(LADDER_POINT_COUNT) + "|");
    }
}
