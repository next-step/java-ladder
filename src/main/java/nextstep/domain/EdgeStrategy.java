package nextstep.domain;

/**
 * 단일 Edge 생성 시 전략 인터페이스
 */
public interface EdgeStrategy {
    /**
     * 0     1     2  : index
     * |-----|     |  : Edge
     *  true  false   : connected
     * @param index 이전 인덱스
     * @param connected 이전 Edge의 연결 여부
     * @return |-----| 으로 반환받아야 할 경우 true
     */
    boolean generate(int index, boolean connected);
}
