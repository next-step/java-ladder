package ladder.view;

import ladder.domain.Game;
import ladder.domain.Line;

import java.util.ArrayList;

public class ResultView {

    public void dataInputResult(Game game) {
        System.out.println("\n실행결과");
        System.out.println(game.formattedNames());

        ArrayList<Line> lines = game.ladderLines();
        lines.forEach(ResultView::printLines);
    }

    private static void printLines(Line line) {
        System.out.print("     ");
        line.getPoints().forEach(point -> {
            String ladderLine = point ? "|-----" : "|     ";
            System.out.print(ladderLine);
        });
        System.out.print("|\n");
    }
}
