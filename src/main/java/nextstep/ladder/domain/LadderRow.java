package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LadderRow {

    private static final int ONE = 1;

    private final List<LadderColumn> ladderColumns;

    public LadderRow(LadderGameSettings settings) {
        this.ladderColumns = new ArrayList<>();
        createLadderColumns(settings);
    }

    private void createLadderColumns(LadderGameSettings settings) {
        addColumn(settings);
        addMiddleColumns(settings);
        addLastColumn();
    }


    private void addMiddleColumns(LadderGameSettings settings) {

        int middleColumnSize = Math.max(getMiddleColumnSize(settings), 0);

        for (int i = 0; i < middleColumnSize; i++) {
            addColumnAfterLineCheck(settings);
        }
    }

    private int getMiddleColumnSize(LadderGameSettings settings) {
        return settings.getLadderWidth() - 2;
    }

    private void addColumnAfterLineCheck(LadderGameSettings settings) {
        if (!hadLegInLastColumn()) {
            addColumn(settings);
            return;
        }
        addNoLegColumn();
    }

    private void addLastColumn() {
        addNoLegColumn();
    }

    private LadderColumn getLastColumn() {
        int lastColumnIndex = Math.max(ladderColumns.size() - ONE, 0);
        return ladderColumns.get(lastColumnIndex);
    }

    private boolean hadLegInLastColumn() {
        return Optional.ofNullable(getLastColumn().hasLeg()).orElse(false);
    }

    private void addNoLegColumn() {
        ladderColumns.add(new LadderColumn());
    }

    private void addColumn(LadderGameSettings settings) {
        ladderColumns.add(LadderColumn.drawVerticalLine(settings.getStrategy()));
    }

    public int getColumnsSize() {
        return ladderColumns.size();
    }

    public List<LadderColumn> getLadderColumns() {
        return ladderColumns;
    }
}
