package ladder.view;

import ladder.domain.Game;
import ladder.domain.Line;
import ladder.domain.Result;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void inputDataInfo(Game game, Result result) {
        System.out.print(System.lineSeparator());
        System.out.println("실행결과");

        System.out.println(game.formattedNames());
        List<Line> lines = game.ladderLines();
        lines.forEach(ResultView::printLines);

        System.out.println(result.formattedResults());
        System.out.print(System.lineSeparator());
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

    public static void printSingleResult(List<String> result) {
        System.out.print(System.lineSeparator());
        System.out.println("실행결과");
        System.out.println(result.get(0));
    }

    public static void printAllResult(List<String> result) {
        System.out.print(System.lineSeparator());
        System.out.println("실행결과");
        result.forEach(System.out::println);
    }
}
