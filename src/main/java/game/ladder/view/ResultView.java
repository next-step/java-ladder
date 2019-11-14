package game.ladder.view;

import game.ladder.domain.Ladder;
import game.ladder.domain.Line;
import game.ladder.domain.Point;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by yusik on 2019/11/09.
 */
public class ResultView {

    private static final String POINT = "|";
    private static final String MOVABLE_LINE = "-----";
    private static final String IMMOVABLE_LINE = "     ";
    private final PrintStream out;

    public ResultView(PrintStream out) {
        this.out = out;
    }

    public void render(Ladder ladder) {
        renderBorder(ladder.getPlayers());
        renderLadder(ladder);
        renderBorder(ladder.getRewards());
    }

    private void renderLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            renderLadderLine(line);
        }
    }

    private void renderLadderLine(Line line) {
        for (Point point : line.getPoints()) {
            out.print(POINT);
            String movableLine = point.isLinkable() ? MOVABLE_LINE : IMMOVABLE_LINE;
            out.print(movableLine);
        }
        out.println();
    }

    private void renderBorder(List<String> items) {
        for (String item : items) {
            out.printf("%-6s", item);
        }
        out.println();
    }

    public void renderResult(String result) {
        out.println("실행 결과");
        out.println(result);
    }

    public void renderAllResult(Ladder ladder) {
        out.println("실행 결과");
        for (String player : ladder.getPlayers()) {
            ladder.getResult(player);
            out.printf("%s : %s\n", player, ladder.getResult(player));
        }
    }
}
