package ladder.domain;

import ladder.domain.type.ColumnConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 사다리의 한 줄을 정의합니다.
 * 불변 객체입니다.
 */
public class LadderLine {
    /**
     * 사다리 컬럼 간의 연결 구조를 나타내는 구조입니다.
     * 인덱스 i번은 i+1번 컬럼과 i+2번 컬럼 사이에 연결이 있는지를 나타냅니다. true면 연결이 있고 false면 연결이 없습니다.
     * 컬럼은 1번부터 시작합니다.
     */
    private final List<ColumnConnection> connectionInfo;

    private LadderLine(List<ColumnConnection> connectionInfo) {
        for (int i = 0; i < connectionInfo.size()-1; i++) {
            checkSuccessiveConnection(connectionInfo, i);
        }

        this.connectionInfo = connectionInfo;
    }

    private static void checkSuccessiveConnection(List<ColumnConnection> connectionInfo, int checkPosition) {
        if (connectionInfo.get(checkPosition).isNotConnected()) {
            return;
        }

        if (checkPosition > 0 && connectionInfo.get(checkPosition-1).isConnected()) {
            throw new IllegalArgumentException("사다리의 컬럼 간 연결이 같은 라인에서 연속으로 연결될 수 없습니다.");
        }

        if (checkPosition < connectionInfo.size()-1 && connectionInfo.get(checkPosition+1).isConnected()) {
            throw new IllegalArgumentException("사다리의 컬럼 간 연결이 같은 라인에서 연속으로 연결될 수 없습니다.");
        }
    }

    /**
     * 컬럼 간의 연결 정보를 이용하여 사다리 한 줄을 생성합니다.
     *
     * @param connectionInfo 사다리 컬럼 간의 연결 구조를 나타내는 구조입니다.
     *                       인덱스 i번은 i+1번 컬럼과 i+2번 컬럼 사이에 연결이 있는지를 나타냅니다
     *
     *                       다음은 컬럼 4개에 대해 `|-| |-|`와 같이 연결되는 정보를 나타내는 방법입니다.
     *                       [CONNECTED, NOT_CONNECTED, CONNECTED]
     *
     * @return 생성된 사다리 라인
     */
    public static LadderLine of(List<ColumnConnection> connectionInfo) {
        return new LadderLine(connectionInfo);
    }

    /**
     * 컬럼 간의 연결 정보를 이용하여 사다리 한 줄을 생성합니다.
     *
     * @param connectionInfo 사다리 컬럼 간의 연결 구조를 나타내는 구조입니다.
     *                       `|`과 `-` 그리고 ` ` (공백 문자)를 이용해 나타냅니다.
     *                       `|`은 컬럼을 의미하고 `|`과 `|` 사이의 `-`는 컬럼 간의 연결을 의미합니다.
     *                       `|`과 `|` 사이에 ` `가 있는 경우 연결이 없음을 의미합니다.
     *                       1번 컬럼과 2번 컬럼이 연결되어 있고 3번과 4번이 연결되어 있는 경우 `|-| |-|`처럼 나타낼 수 있습니다.
     *
     * @return 생성된 사다리 라인
     */
    public static LadderLine of(String connectionInfo) {
        List<ColumnConnection> booleanConnectionInfo = new ArrayList<>();

        for (int p = 1; p < connectionInfo.length() - 1; p += 2) {
            char connectionSymbol = connectionInfo.charAt(p);
            if (connectionSymbol == '-') {
                booleanConnectionInfo.add(ColumnConnection.CONNECTED);
            }
            else {
                booleanConnectionInfo.add(ColumnConnection.NOT_CONNECTED);
            }
        }

        return LadderLine.of(booleanConnectionInfo);
    }

    public int howManyColumns() {
        return this.connectionInfo.size() + 1;
    }

    public boolean hasTheSameNumberOfColumn(int theNumberOfColumn) {
        return howManyColumns() == theNumberOfColumn;
    }

    /**
     * 컬럼이 우측 컬럼과 이어져 있는지를 확인합니다.
     *
     * @param leftColumnIndex 컬럼 번호입니다. 0부터 시작합니다.
     *
     * @return 주어진 컬럼이 우측 컬럼과 연결되어 있다면 true를 반환합니다.
     */
    public ColumnConnection isConnected(int leftColumnIndex) {
        if (leftColumnIndex < 0 || leftColumnIndex >= howManyColumns()) {
            throw new IllegalArgumentException("주어진 컬럼 번호 " + leftColumnIndex +"는 존재하지 않습니다.");
        }

        if (leftColumnIndex == howManyColumns() - 1) {
            return ColumnConnection.NOT_CONNECTED;
        }

        return this.connectionInfo.get(leftColumnIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderLine that = (LadderLine) o;
        return Objects.equals(connectionInfo, that.connectionInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionInfo);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "connectionInfo=" + connectionInfo +
                '}';
    }

    /**
     * 이 타입과 호환되지 않는 곳에서 LadderLine을 사용하기 위해 리스트로 변환합니다.
     *
     * @return 컬럼 간 연결 정보
     */
    public List<ColumnConnection> toList() {
        return List.copyOf(this.connectionInfo);
    }
}