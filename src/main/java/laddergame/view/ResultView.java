package laddergame.view;

import java.util.List;
import laddergame.domain.LadderGame;
import laddergame.domain.Line;

public class ResultView {

    private final LadderGame ladderGame;

    public ResultView(final LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void printResult() {
        System.out.println("실행결과");
        System.out.println();

        StringBuilder sb = new StringBuilder();

        ladderGame.getNames().forEach(n -> sb.append(n).append("      "));
        sb.append("\n");

        List<Line> linePerDepth = ladderGame.getLinePerDepth();
        linePerDepth.forEach(line -> {
            sb.append("|");
            line.getPoints().forEach(e -> printLine(sb, e));
            sb.append("\n");
        });
        System.out.println(sb);
    }

    private void printLine(final StringBuilder sb, final Boolean point) {
        if (point) {
            sb.append("------").append("|");
            return;
        }
        sb.append("      ").append("|");
    }
}

