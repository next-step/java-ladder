package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Point;

import java.util.List;

public class ResultView {
    private static final String POINT_MARK = "-".repeat(5);
    private static final String EMPTY_POINT_MARK = " ".repeat(5);
    private static final String POINT_SEPARATOR = "|";

    public static void printPeople(List<Person> people) {
        System.out.print("\n실행결과\n\n");
        people.forEach(person -> System.out.printf("%6s", person.getName()));

        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder ladderMark = new StringBuilder();
        ladder.getLines()
                .forEach(line ->
                    ladderMark.append(EMPTY_POINT_MARK)
                            .append(POINT_SEPARATOR)
                            .append(getLadderLineMark(line))
                            .append("\n")
                );

        System.out.println(ladderMark);
    }

    private static StringBuilder getLadderLineMark(Line line) {
        StringBuilder ladderLineMark = new StringBuilder();

        line.getPoints()
                .forEach(point -> ladderLineMark.append(getLadderPointMark(point))
                        .append(POINT_SEPARATOR));

        return ladderLineMark;
    }

    private static String getLadderPointMark(Point point) {
        if (point.getValue()) {
            return POINT_MARK;
        }
        return EMPTY_POINT_MARK;
    }
}
