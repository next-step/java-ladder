package ladder;

import java.util.List;
import java.util.Optional;

/**
 * 사다리의 한 줄을 정의합니다.
 * 불변 객체로 설계하십시오.
 * 일종의 LadderColumn의 일급 컬렉션으로서 기능합니다.
 */
public interface LadderLine {

    /**
     * 이 사다리 라인이 몇 개의 컬럼을 가지고 있는지 구합니다.
     *
     * @return 컬럼 개수
     */
    public int howManyColumns();


    /**
     * 이 사다리 라인이 주어진 숫자와 동일한 개수의 컬럼을 가지고 있는지 판단합니다.
     *
     * @param theNumberOfColumn 몇 개나 가지고 있는지 확인할 숫자
     *
     * @return 컬럼 개수와 주어진 숫자가 같으면 true
     */
    public default boolean hasTheSameNumberOfColumn(int theNumberOfColumn) {
        return howManyColumns() == theNumberOfColumn;
    }

    /**
     * 주어진 컬럼에서 이동하게 되는 컬럼을 반환합니다.
     *
     * @param columnIndex 시작 컬럼 인덱스
     * @return 이동 후 컬럼 인덱스
     */
    public int connectedColumnOf(int columnIndex);

    /**
     * 이 타입과 호환되지 않는 곳에서 사용하기 위해 원시값으로 연결 정보를 나타내는 리스트를 생성합니다.
     * 도메인 구역에서 이 메서드를 사용하지 마십시오.
     */
    public List<Boolean> toConnectionInfos();
}