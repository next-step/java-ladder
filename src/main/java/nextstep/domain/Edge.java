package nextstep.domain;

import java.util.Optional;

/**
 * Line 내부 각 Node를 연결하는 엣지
 */
public class Edge {
    private final int index; // 왼쪽 기준 노드를 인덱스로 잡음
    private final boolean connected;

    /* 기본 생성자 */
    public Edge(int index, boolean connected) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("인덱스는 0이 될 수 없습니다.");
        }
        this.index = index;
        this.connected = connected;
    }

    /* Edge의 상태 반환 */
    public boolean isConnected() {
        return connected;
    }

    /* Optional로 연결되어 있다면 다른쪽 반환 */
    public Optional<Integer> otherSide(int pos) {
        if (!connected) {
            return Optional.empty();
        }
        if (pos == index) {
            return Optional.of(index + 1);
        }
        if (pos == index + 1) {
            return Optional.of(index);
        }
        return Optional.empty();
    }
}
