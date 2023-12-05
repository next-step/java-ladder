package ladder.domain.ladder;

import java.util.*;

/**
 * 사다리의 한 줄을 정의합니다.
 * 불변 객체입니다.
 * 일종의 LadderColumn의 일급 컬렉션으로서 기능합니다.
 */
public class LadderLine {
    private final List<LadderColumn> columns;

    public LadderLine(List<LadderColumn> columns) {
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
            throw new IllegalArgumentException("컬럼 간에는 쌍방으로 연결되어 있으나 연결이 파편화 되어 있습니다.");
        }

        if (columns.get(columnIndex).isConnectedLeft() && columns.get(columnIndex -1).isNotConnectedRight()) {
            throw new IllegalArgumentException("컬럼 간에는 쌍방으로 연결되어 있으나 연결이 파편화 되어 있습니다.");
        }
    }

    public int howManyColumns() {
        return this.columns.size();
    }

    public boolean hasTheSameNumberOfColumn(int theNumberOfColumn) {
        return howManyColumns() == theNumberOfColumn;
    }

    /**
     * 주어진 컬럼에서 이동하게 되는 컬럼을 반환합니다.
     *
     * @param columnIndex 시작 컬럼 인덱스
     * @return 이동 후 컬럼 인덱스
     */
    public int connectedColumnOf(int columnIndex) {
        return this.columns.get(columnIndex).connectedColumnIndex();
    }

    /**
     * 이 타입과 호환되지 않는 곳에서 사용하기 위해 원시값으로 연결 정보를 나타내는 리스트를 생성합니다.
     * 도메인 구역에서 이 메서드를 사용하지 마십시오.
     */
    public List<Boolean> toConnectionInfos() {
        List<Boolean> connectionInfos = new ArrayList<>();

        for (int columnIndex = 0; columnIndex < this.columns.size() - 1; columnIndex++) {
            connectionInfos.add(this.columns.get(columnIndex).isConnectedRight());
        }

        return connectionInfos;
    }
}