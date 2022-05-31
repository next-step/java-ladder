package ladder.ui;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;

public class ResultView {
    public static void printResult(List<String> participants, Ladder ladder) {
        participants.forEach(it -> {
            it = "       " + it;
            it = it.substring(it.length() - 6);
            System.out.print(it);
        });
        System.out.println();

        List<Line> lines = ladder.getLines();

        lines.forEach(it -> printLine(it.getPoints()));
    }

    private static void printLine(List<Point> points) {
        System.out.print("     ");
        points.forEach(it -> {
            if (it.isExist()) {
                System.out.print("|-----");
                return;
            }

            System.out.print("|     ");
        });
        System.out.println("|");
    }
}
