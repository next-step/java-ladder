package ladder.view.result;

import ladder.model.Ladder;
import ladder.model.LadderRow;

public class LadderView implements FormattableView {
    private static final String LADDER_STEP = "-";
    private static final String LADDER_STILE = "|";
    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public void render(int formatWidth) {
        for (int index = 0; index < ladder.height(); index++) {
            renderRow(ladder.rowAt(index), formatWidth);
            System.out.println();
        }
    }

    private void renderRow(LadderRow row, int formatWidth) {
        System.out.print(ladderExpression(formatWidth, false));

        for (int column = 0; column < row.size(); column++) {
            boolean existence = row.exists(column);
            System.out.print(ladderExpression(formatWidth, existence));
        }
    }

    private String ladderExpression(int width, boolean exists) {
        String step = exists ? LADDER_STEP : " ";
        return step.repeat(width - LADDER_STILE.length()) + LADDER_STILE;
    }
}
