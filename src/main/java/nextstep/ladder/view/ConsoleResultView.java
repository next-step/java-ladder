package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.LineRenderer;

import java.util.function.Consumer;

public class ConsoleResultView implements ResultView {
    @Override
    public void printLadder(Ladder ladder) {
        StringBuilder ladderBuilder = new StringBuilder();
        LineRenderer lineRenderer = LineRenderer.of(renderPoints(ladderBuilder), renderLastPartOfLine(ladderBuilder));
        ladder.repeatAsHeight(lineRenderer);

        System.out.println(ladderBuilder.toString());
    }

    private Consumer<Boolean> renderPoints(StringBuilder sb) {
        return point -> {
            sb.append("|");
            sb.append(point ? "-----" : "     ");
        };
    }

    private Runnable renderLastPartOfLine(StringBuilder sb) {
        return () -> sb.append("|").append(System.lineSeparator());
    }
}
