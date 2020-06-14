package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    @Test
    @DisplayName("Direction 생성")
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("Direction 생성 예외")
    public void init_invalid() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("라인이 겹칠 수 없습니다.");
    }

    @Test
    @DisplayName("Line이 True일 경우 Next Line은 False")
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("Line이 False일 경우 Next Line은 Random")
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
        }
    }

    @Test
    @DisplayName("Next Line True 생성")
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("Next Line False 생성")
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("첫번째 Line 왼쪽은 항상 False")
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @Test
    @DisplayName("마지막 Line 오른쪽은 항상 False")
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last.isRight()).isEqualTo(FALSE);
    }
}
