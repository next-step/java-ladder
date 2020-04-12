package ladder.domain;

import ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WayTest {

    private LadderMoveStrategy strategyTrue;
    private LadderMoveStrategy strategyFalse;

    @BeforeEach
    void setUp() {
        strategyTrue = () -> {
            return true;
        };
        strategyFalse = () -> {
            return false;
        };
    }

    @DisplayName("생성자 정상 테스트")
    @Test
    public void constructor_success() throws Exception {
        //then
        assertThat(new Way(true, false));
        assertThat(new Way(false, true));
        assertThat(new Way(false, false));
    }

    @DisplayName("양방향 이동은 불가능 하다")
    @Test
    public void validate_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new Way(true, true)
        ).isInstanceOf(LadderException.class);
    }

    @DisplayName("왼쪽/오른쪽 이동 방향으로 움직일수 있는지 체크")
    @Test
    public void left_right() throws Exception {
        //given
        Way left = new Way(true, false);
        Way right = new Way(false, true);
        Way none = new Way(false, false);

        //then
        assertTrue(left.isMovableLeft());
        assertFalse(left.isMovableRight());
        assertTrue(right.isMovableRight());
        assertFalse(right.isMovableLeft());
        assertFalse(none.isMovableLeft());
        assertFalse(none.isMovableRight());
    }

    @DisplayName("오른쪽 진행 가능할 경우 다음 방향은 오른쪽 진행 불가 함")
    @Test
    public void next_success_cantRight() throws Exception {
        //given
        Way way = new Way(false, true);

        //when
        Way next = way.next(strategyTrue);

        //then

        assertFalse(next.isMovableRight());
    }

    @DisplayName("오른쪽 진행 불가 할 경우 다음 방향은 랜덤으로 생성")
    @Test
    public void next_success_randomMove() throws Exception {
        //given
        Way way = new Way(false, false);

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
        Way way = new Way(false, true);

        //when
        Way last = way.last();

        //then
        assertFalse(last.isMovableRight());
    }
}
