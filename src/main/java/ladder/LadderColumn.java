package ladder;

/**
 * 사다리의 한 포인트를 나타냅니다.
 * 개념적으로 |-|에서 | 부분들을 나타냅니다.
 * 불변 객체로 설계하십시오.
 */
public interface LadderColumn {
    /**
     * 우측으로 연결되어 있다면 true
     */
    public Boolean isConnectedRight();

    /**
     * 좌측으로 연결되어 있다면 true
     */
    public boolean isConnectedLeft();

    /**
     * 우측으로 연결되어 있지 않다면 true
     */
    public default boolean isNotConnectedRight() {
        return !isConnectedRight();
    }

    /**
     * 좌측으로 연결되어 있지 않다면 true
     */
    public default boolean isNotConnectedLeft() {
        return !isConnectedLeft();
    }

    /**
     * 왼쪽이나 오른쪽 둘 중 한쪽이라도 연결이 있다면 true
     */
    public default boolean isConnected() {
        return isConnectedLeft() || isConnectedRight();
    }

    /**
     * 양쪽으로 모두 연결이 없다면 true
     */
    public default boolean isNotConnected() {
        return isNotConnectedLeft() && isNotConnectedRight();
    }


    /**
     * 이 컬럼과 연결된 컬럼의 인덱스 번호를 반환합니다.
     * 연결 된 것이 없다면 자신의 인덱스 번호를 반환합니다.
     *
     * @return 연결된 컬럼 인덱스
     */
    public int connectedColumnIndex();

    /**
     * 이 컬럼의 인덱스가 주어진 인덱스와 일치하는지 확인합니다.
     *
     * @param columnIndex 검사할 컬럼
     * @return 일치하면 true
     */
    public boolean areYou(int columnIndex);
}