package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private static final int ONE = 1;
    private static final int FIRST_AND_LAST_COLUMN_COUNT = 2;

    private final List<LadderColumn> ladderColumns;

    public LadderRow(LadderGameSettings settings) {
        this.ladderColumns = new ArrayList<>();
        createLadderColumns(settings);
    }

    private void createLadderColumns(LadderGameSettings settings) {

        final int ladderWidth = settings.getLadderWidth();

        if (ladderWidth == ONE) {
            addNoVerticalLineColumn();
            return;
        }

        addFirstColumn(settings);
        addMiddleColumns(settings);
        addLastColumn();
    }

    private void addFirstColumn(LadderGameSettings settings) {
        addColumn(settings);
    }

    private void addMiddleColumns(LadderGameSettings settings) {
        int middleSize = getMiddleSize(settings);

        for (int i = 0; i < middleSize; i++) {

            if (!hadVerticalLineInLastColumn(ladderColumns)) {
                addColumn(settings);
                continue;
            }
            addNoVerticalLineColumn();
        }
    }

    private int getMiddleSize(LadderGameSettings settings) {
        final int ladderWidth = settings.getLadderWidth();
        return Math.max(ladderWidth - FIRST_AND_LAST_COLUMN_COUNT, 0);
    }

    private void addLastColumn() {
        addNoVerticalLineColumn();
    }

    private boolean hadVerticalLineInLastColumn(List<LadderColumn> columns) {
        return ladderColumns.get(columns.size() - ONE).value();
    }

    private void addNoVerticalLineColumn() {
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
