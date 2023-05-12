package laddergame.view;

import java.util.List;
import laddergame.domain.LadderGame;
import laddergame.domain.Line;

public class ResultView {

    private static final String WIDTH_LINE = "------";
    private static final String BLANK = "      ";
    private static final String HEIGHT_LINE = "|";
    private static final String NEW_LINE = "\n";

    private final LadderGame ladderGame;

    public ResultView(final LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void printResult() {
        System.out.println("실행결과");
        System.out.println();

        StringBuilder sb = new StringBuilder();
        printNames(sb);
        printLadder(sb);

        System.out.println(sb);
    }

    private void printNames(final StringBuilder sb) {
        ladderGame.getNames().forEach(name -> sb.append(name).append(BLANK));
        sb.append(NEW_LINE);
    }

    private void printLadder(final StringBuilder sb) {
        List<Line> linePerDepth = ladderGame.getLinePerDepth();
        linePerDepth.forEach(line -> {
            sb.append(HEIGHT_LINE);
            line.getPoints().forEach(isTrue -> printLine(sb, isTrue));
            sb.append(NEW_LINE);
        });
    }

    private void printLine(final StringBuilder sb, final Boolean isTrue) {
        if (isTrue) {
            sb.append(WIDTH_LINE).append(HEIGHT_LINE);
            return;
        }
        sb.append(BLANK).append(HEIGHT_LINE);
    }
}

