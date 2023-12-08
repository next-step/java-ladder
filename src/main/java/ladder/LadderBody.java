package ladder;

import java.util.List;

/**
 * 사다리를 정의합니다.
 * 사다리는 사다리 라인의 묶음입니다.
 * 불변 객체입니다.
 */
public interface LadderBody {
    /**
     * 이 사다리의 깊이를 반환합니다.
     *
     * @return 사다리 깊이
     */
    int howLongDepth();

    /**
     * 주어진 컬럼 번호에서 시작했을 때 도착하게 되는 컬럼 번호를 계산합니다.
     *
     * @param columnIndex 시작 컬럼 번호
     *
     * @return 도착 컬럼 번호
     */
    int calculateResultOf(int columnIndex);

    /**
     * 이 타입과 호환되 않는 곳에서 Ladder를 사용하기 위해 List로 변환합니다.
     *
     * @return 사다리 연결 정보
     */
    public List<LadderLine> toList();
}
