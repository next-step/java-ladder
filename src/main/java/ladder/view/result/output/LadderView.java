package ladder.view.result.output;

import ladder.model.ladder.Ladder;
import ladder.model.ladder.LadderRow;

public class LadderView implements FormattableView {
    private static final String LADDER_STEP = "-";
    private static final String LADDER_STILE = "|";
    private static final String LADDER_NONE = " ";
    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    private static String padding(int formatWidth) {
        return " ".repeat(formatWidth - 1);
    }

    @Override
    public void render(int formatWidth) {
        for (int index = 0; index < ladder.height(); index++) {
            renderRow(ladder.rowAt(index), formatWidth);
            System.out.println();
        }
    }

    private void renderRow(LadderRow row, int formatWidth) {
        System.out.print(padding(formatWidth));
        row.stiles().forEach(
                stile -> System.out.print(ladderExpression(formatWidth, stile.isRightConnected()))
        );
    }

    private String ladderExpression(int width, boolean rightConnected) {
        String step = rightConnected ? LADDER_STEP : LADDER_NONE;
        return LADDER_STILE + step.repeat(width - LADDER_STILE.length());
    }
}
