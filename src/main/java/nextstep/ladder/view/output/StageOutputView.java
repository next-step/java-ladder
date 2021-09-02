package nextstep.ladder.view.output;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.line.HorizontalLine;

import java.util.List;

public class StageOutputView {

    private static final String LADDER_NOT_EXISTS_HORIZONTAL_LINE_PADDING = "     ";
    private static final String LADDER_HEIGHT_UNIT = "|";
    private static final String LADDER_HORIZONTAL_LINE = "-----";

    public void appendLadders(List<Ladder> ladders, StringBuilder stringBuilder) {
        Ladder ladder = ladders.get(0);

        int maxHeight = ladder.getHeight();
        for (int height = 0; height < maxHeight; height++) {
            appendLadderPerHeight(ladders, stringBuilder, height);
        }

        int lastNewLineIndex = stringBuilder.lastIndexOf(OutputView.NEW_LINE);
        stringBuilder.delete(lastNewLineIndex, stringBuilder.length());
    }

    private void appendLadderPerHeight(List<Ladder> ladders, StringBuilder stringBuilder, int height) {
        stringBuilder.append(LADDER_NOT_EXISTS_HORIZONTAL_LINE_PADDING);
        ladders.forEach((l) -> appendLadder(l, stringBuilder, height));
        stringBuilder.append(OutputView.NEW_LINE);
    }

    private void appendLadder(Ladder ladder, StringBuilder stringBuilder, int index) {
        stringBuilder.append(LADDER_HEIGHT_UNIT);
        List<HorizontalLine> horizontalLines = ladder.getHorizontalLines();
        HorizontalLine horizontalLine = horizontalLines.get(index);
        if (horizontalLine.exist()) {
            stringBuilder.append(LADDER_HORIZONTAL_LINE);
            return;
        }
        stringBuilder.append(LADDER_NOT_EXISTS_HORIZONTAL_LINE_PADDING);
    }
}
