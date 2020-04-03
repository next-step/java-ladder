package ladder.domain;

import ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WayTest {

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

    @DisplayName("이동 방향으로 움직일수 있는지 체크")
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

    @DisplayName("캐싱 데이터 확인")
    @Test
    public void cache() throws Exception {
        //given
        Way left = Way.left();
        Way right = Way.right();
        Way none = Way.none();

        //then
        assertTrue(left.isMovableLeft());
        assertFalse(left.isMovableRight());
        assertTrue(right.isMovableRight());
        assertFalse(right.isMovableLeft());
        assertFalse(none.isMovableLeft());
        assertFalse(none.isMovableRight());
    }
}
