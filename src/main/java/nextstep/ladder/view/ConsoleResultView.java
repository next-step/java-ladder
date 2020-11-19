package nextstep.ladder.view;

import nextstep.ladder.Ladder;
import nextstep.ladder.LineRenderer;

import java.util.function.Consumer;

public class ConsoleResultView implements ResultView {
    private static final String LADDER_STICK = "|";
    private static final String EXIST_POINT = "-----";
    private static final String EMPTY_POINT = "     ";

    @Override
    public void printLadder(Ladder ladder) {
        StringBuilder ladderBuilder = new StringBuilder();
        LineRenderer lineRenderer = LineRenderer.of(renderPoints(ladderBuilder), renderLastPartOfLine(ladderBuilder));
        ladder.repeatAsHeight(lineRenderer);

        System.out.println(ladderBuilder.toString());
    }

    private Consumer<Boolean> renderPoints(StringBuilder sb) {
        return point -> {
            sb.append(LADDER_STICK);
            sb.append(point ? EXIST_POINT : EMPTY_POINT);
        };
    }

    private Runnable renderLastPartOfLine(StringBuilder sb) {
        return () -> sb.append(LADDER_STICK).append(System.lineSeparator());
    }
}
