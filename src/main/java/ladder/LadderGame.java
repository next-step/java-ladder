package ladder;

import java.util.List;

/**
 * 참여자 이름, 사다리 구조, 실행 결과로 이루어진 사다리 게임을 표현합니다.
 * 불변 객체입니다.
 */
public interface LadderGame {

    /**
     * 주어진 이름의 사다리 실행 결과를 계산하여 반환합니다.
     *
     * @param who 실행 결과를 볼 사람의 이름
     * @return 그 사람의 실행 결과
     */
    public LadderResult calculateResultOf(LadderParticipant who);

    public LadderResultSet calculateResultsOfAll();

    /**
     * 사다리 게임에 참여한 사람의 목록
     * 목록은 0번 컬럼에 대응하는 사람부터 순서대로 나와야 합니다.
     */
    List<LadderParticipant> participants();

    /**
     * 사다리 게임 몸체
     */
    LadderBody ladderBody();

    /**
     * 사다리 게임 결과 아이템 목록
     * 목록은 0번 컬럼에 대응하는 아이템부터 순서대로 나와야 합니다.
     */
    List<LadderResultItem> resultItems();
}
