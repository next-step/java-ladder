package ladder.view.result;

import ladder.model.Ladder;
import ladder.model.LadderRow;

import java.util.stream.IntStream;

public class LadderView implements FormattableView {
    private static final String LADDER_STEP = "-";
    private static final String LADDER_STILE = "|";
    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public void render() {
        render(0);
    }

    @Override
    public void render(int formatWidth) {
        for (int index = 0; index < ladder.height(); index++) {
            renderRow(ladder.rowAt(index), formatWidth);
            System.out.println();
        }
    }

    private void renderRow(LadderRow row, int formatWidth) {
        IntStream.range(0, row.size())
                .mapToObj(row::exists)
                .map((existence) -> ladderExpression(formatWidth, existence))
                .forEach(System.out::print);
    }

    private String ladderExpression(int width, boolean exists) {
        String step = exists ? LADDER_STEP : " ";
        return step.repeat(width - LADDER_STILE.length()) + LADDER_STILE;
    }
}
