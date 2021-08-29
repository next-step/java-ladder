package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nextstep.ladder.strategy.RandomDrawLineStrategy;

public class LadderRow {

    List<LadderColumn> ladderColumns;

    public LadderRow(int ladderWidth) {
        this.ladderColumns = createLadderColumns(ladderWidth);
    }


    private List<LadderColumn> createLadderColumns(int ladderWidth) {

        if (ladderWidth == 1) {
            return Collections.singletonList(new LadderColumn());
        }

        List<LadderColumn> xxx = new ArrayList<>(ladderWidth);
        addFirstColumn(xxx);
        addMiddleColumns(xxx, ladderWidth);
        addNoVerticalLineColumn(xxx);

        return Collections.unmodifiableList(xxx);
    }


    private void addMiddleColumns(List<LadderColumn> xxx, int ladderWidth) {

        int middleSize = Math.max(ladderWidth - 2, 0);

        for (int i = 0; i < middleSize; i++) {

            if (!hadVerticalLineInLastColumn(xxx)) {
                addColumn(xxx);
                continue;
            }
            addNoVerticalLineColumn(xxx);
        }
    }

    private boolean hadVerticalLineInLastColumn(List<LadderColumn> xxx) {
        return xxx.get(xxx.size() - 1).value();
    }

    private void addNoVerticalLineColumn(List<LadderColumn> xxx) {
        xxx.add(new LadderColumn());
    }

    private void addFirstColumn(List<LadderColumn> xxx) {
        addColumn(xxx);
    }

    private void addColumn(List<LadderColumn> xxx) {
        xxx.add(LadderColumn.drawLine(new RandomDrawLineStrategy()));
    }

}
