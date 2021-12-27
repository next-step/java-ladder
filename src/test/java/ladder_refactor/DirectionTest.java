package ladder_refactor;

import ladder_refactor.domain.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    @DisplayName("방향 초기화 테스트")
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("방향은 왼쪽 오른쪽을 같이 가질 수 없다")
    public void init_invalid() {
        Assertions.assertThatThrownBy(() -> Direction.of(TRUE, TRUE)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("첫번째 값 오른쪽 true 일시 next는 왼쪽 true 오른쪽 false")
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        Assertions.assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("첫번째 값 아래방향일시 next는 왼쪽 false, 오른쪽 랜덤값이다")
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
        }
    }

    @Test
    @DisplayName("왼쪽으로 이동하는 방향 다음 방향 true 테스트")
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        Assertions.assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("오른쪽으로 이동하는 방향 다음 방향 false 테스트")
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        Assertions.assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("처음 방향 테스트")
    public void first() {
        Direction first = Direction.first(TRUE);
        Assertions.assertThat(first).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("해당 방향에서의 마지막 방향 테스트")
    public void last() {
        Direction last = Direction.first(TRUE).last();
        Assertions.assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
