package ladder.ui.console;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.People;

import java.util.List;

public class ResultView {
    private static final String TRUE_POINT = "-----|";
    private static final String FALSE_POINT = "     |";

    public static void ladderResult(Ladder ladder) {
        System.out.println("실행결과");

        People people = ladder.getPeople();
        people.getPeople().stream().forEach(person -> {
            System.out.print(String.format("%6s", person.getName()));
        });

        List<Line> lines = ladder.getLines();
        System.out.println();
        lines.stream().forEach(line -> {
            List<Boolean> points = line.getPoints();
            points.stream().forEach(point-> System.out.print(point ? TRUE_POINT : FALSE_POINT));
            System.out.println();
        });
    }
}
