package ladder.view;

import ladder.domain.Game;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void dataInputResult(Game game) {
        System.out.print(System.lineSeparator());
        System.out.println("실행결과");
        System.out.println(game.formattedNames());

        List<Line> lines = game.ladderLines();
        lines.forEach(ResultView::printLines);
    }

    private static void printLines(Line line) {
        System.out.print("     ");
        line.getPoints().forEach(point -> {
            if (point) {
                System.out.print("|-----");
            }
            if (!point) {
                System.out.print("|     ");
            }
        });
        System.out.print("|");
        System.out.print(System.lineSeparator());
    }
}
