package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("오른쪽이면서 왼쪽인 Direction 객체 생성 시 예외 발생")
    public void init_invalid() {
        assertThatThrownBy( () -> {
            Direction.of(TRUE, TRUE);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("오른쪽으로 연결된 첫 Point객체의 바로 다음 객체는 왼쪽으로 연결되어있어야 한다.")
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("RandomDirectionGenerator의 generate() 메서드가 return FALSE;인 경우만 통과")
    public void next_random_false() {
        Direction next = Direction.first(FALSE).next();
        assertThat(next).isEqualTo(Direction.of(FALSE,FALSE));
    }

    @Test
    @DisplayName("next()에 파라미터로 오른쪽 방향여부를 주입받았을 경우 테스트")
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("next()에 파라미터로 오른쪽 방향여부를 주입받았을 경우 테스트")
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("첫번째 포인트 생성 테스트")
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    @DisplayName("마지막 포인트 생성 테스트")
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
