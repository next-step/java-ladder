package seungjun.ladder;

import ladder.LadderColumn;
import ladder.LadderLine;

import java.util.*;


public class SeungjunLadderLine implements LadderLine {
    private final List<LadderColumn> columns;

    public SeungjunLadderLine(List<LadderColumn> columns) {
        validateLadderColumns(columns);

        this.columns = List.copyOf(columns);
    }

    private static void validateLadderColumns(List<LadderColumn> columns) {
        validateColumnOrder(columns);
        validateColumnConnection(columns);
    }

    private static void validateColumnOrder(List<LadderColumn> columns) {
        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            if (columns.get(columnIndex).areYou(columnIndex) == false) {
                throw new IllegalArgumentException("컬럼 순서가 정렬되어 지급되지 않았습니다.");
            }
        }
    }

    private static void validateColumnConnection(List<LadderColumn> columns) {
        if (columns.get(0).isConnectedLeft()) {
            throw new IllegalArgumentException("최좌측 컬럼은 왼쪽으로 연결될 수 없으나 그러한 컬럼이 발견되었습니다.");
        }

        if (columns.get(columns.size()-1).isConnectedRight()) {
            throw new IllegalArgumentException("최우측 컬럼은 오른쪽으로 연결될 수 없으나 그러한 컬럼이 발견되었습니다.");
        }

        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            validateBidirectionConnection(columns, columnIndex);
        }
    }

    private static void validateBidirectionConnection(List<LadderColumn> columns, int columnIndex) {
        if (columns.get(columnIndex).isNotConnected()) {
            return;
        }

        if (columns.get(columnIndex).isConnectedRight() && columns.get(columnIndex +1).isNotConnectedLeft()) {
            throw new IllegalArgumentException("컬럼 간에는 쌍방으로 연결되어 있어야 하나 연결이 파편화 되어 있습니다.");
        }

        if (columns.get(columnIndex).isConnectedLeft() && columns.get(columnIndex -1).isNotConnectedRight()) {
            throw new IllegalArgumentException("컬럼 간에는 쌍방으로 연결되어 있어야 하나 연결이 파편화 되어 있습니다.");
        }
    }

    @Override
    public int howManyColumns() {
        return this.columns.size();
    }

    @Override
    public int connectedColumnOf(int columnIndex) {
        return this.columns.get(columnIndex).connectedColumnIndex();
    }

    @Override
    public List<Boolean> toConnectionInfos() {
        List<Boolean> connectionInfos = new ArrayList<>();

        for (int columnIndex = 0; columnIndex < this.columns.size() - 1; columnIndex++) {
            connectionInfos.add(this.columns.get(columnIndex).isConnectedRight());
        }

        return connectionInfos;
    }
}