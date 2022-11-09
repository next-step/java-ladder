package ladder;

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
    public void init_invalid() {
        assertThatThrownBy(() -> {
            Direction.of(TRUE, TRUE);
        }).isInstanceOf(IllegalStateException.class);

    }

    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("이전이 오른쪽과 연결되어 있다면 다음은 오른쪽과 무조건 연결되어 있지 않다.")
    public void test1() {
        Direction direction = Direction.first(TRUE).next(() -> true);
        assertThat(direction.isRight()).isFalse();
    }

    @Test
    @DisplayName("이전이 오른쪽과 연결되어 있지 않다면 다음은 오른쪽과 연결될 수 있다.")
    public void test2() {
        Direction direction = Direction.first(FALSE).next(() -> true);
        assertThat(direction.isRight()).isTrue();
    }

}
