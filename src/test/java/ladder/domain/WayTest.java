package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WayTest {

    public static LadderMoveStrategy strategyTrue = () -> {
        return true;
    };
    public static LadderMoveStrategy strategyFalse = () -> {
        return false;
    };

    @DisplayName("이동 불가능한 첫 방향 생성")
    @Test
    public void from_success_cantMove() throws Exception {
        //given
        Way way = Way.from(strategyFalse);

        //then
        assertFalse(way.isMovableLeft());
        assertFalse(way.isMovableRight());

    }

    @DisplayName("오른쪽 이동 가능한 첫 방향 생성")
    @Test
    public void from_success_moveRight() throws Exception {
        //given
        Way way = Way.from(strategyTrue);

        //then
        assertFalse(way.isMovableLeft());
        assertTrue(way.isMovableRight());

    }

    @DisplayName("오른쪽 진행 가능할 경우 다음 방향은 오른쪽 진행 불가 함")
    @Test
    public void next_success_cantRight() throws Exception {
        //given
        Way way = Way.from(strategyTrue);

        //when
        Way next = way.next(strategyTrue);

        //then

        assertFalse(next.isMovableRight());
    }

    @DisplayName("오른쪽 진행 불가 할 경우 다음 방향은 랜덤으로 생성")
    @Test
    public void next_success_randomMove() throws Exception {
        //given
        Way way = Way.from(strategyFalse);

        //when
        Way right = way.next(strategyTrue);
        Way none = way.next(strategyFalse);

        //then

        assertTrue(right.isMovableRight());
        assertFalse(none.isMovableRight());
    }

    @DisplayName("마지막 방향은 오른쪽 진행 방향이 false 이다")
    @Test
    public void first_success() throws Exception {
        //given
        Way way = Way.from(strategyTrue);

        //when
        Way last = way.last();

        //then
        assertFalse(last.isMovableRight());
    }
}
