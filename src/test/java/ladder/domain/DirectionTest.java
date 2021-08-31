package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @Test
    @DisplayName("초기화 테스트")
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("왼쪽, 오른쪽 모두 true 일 때 실패 테스트")
    public void init_invalid() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE)).isInstanceOf(RuntimeException.class);
        ;
    }

    @Test
    @DisplayName("첫번째 Direction 테스트")
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("첫번째일때 왼쪽 Direction 테스트")
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }
    @Test
    @DisplayName("다음 랜덤 Direction 테스트")
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("마지막 Direction 테스트")
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}