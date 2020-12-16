package ladder.domain.next;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("좌,우 boolean 값을 인자로 객체를 생성할 수 있다")
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("좌,우 양방향으로 상태를 설정할 수 없다")
    @Test
    public void init_invalid() {
        assertThatThrownBy( () -> Direction.of(true, true))
                .isInstanceOf(IllegalStateException.class);
    }


    @DisplayName("이전 방향으로 이동가능하면 next 시 오른쪽으로는 이동 할 수 없다")
    @Test
    public void next_random_false() {
        for(int i = 0; i < 100; i++){
            Direction next = Direction.first(true).next();
            assertThat(next).isEqualTo(Direction.of(true, false));
        }
    }

    @DisplayName("next(true) 하면 이전 left 는 이전 direction 의 right, right 는 true 로 설정된다")
    @Test
    public void next_true() {
        Direction next = Direction.of(true, false).next(true);
        assertThat(next).isEqualTo(Direction.of(false, true));
    }

    @DisplayName("next(false) 하면 이전 left 는 이전 direction 의 right, right 는 false 로 설정된다")
    @Test
    public void next_false() {
        Direction next = Direction.of(false, true).next(false);
        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("방향의 처음은 left=false 이어야 한다")
    @Test
    public void first() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isEqualTo(false);
    }

    @DisplayName("방향의 마지막은 right=false 이어야 하고 left 는 이전 방향 right 와 같다")
    @Test
    public void last() {
        Direction last = Direction.first(true).last();
        assertThat(last).isEqualTo(Direction.of(true, false));
    }

}