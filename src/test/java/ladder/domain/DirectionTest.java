package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DirectionTest {
    @Test
    @DisplayName("of 메서드를 통해 좌 방향을 가진 Direction 을 생성한다.")
    void of() {
        assertThat(Direction.of(TRUE, FALSE).isLeft()).isTrue();
        assertThat(Direction.of(TRUE, FALSE).isRight()).isFalse();
    }

    @Test
    @DisplayName("of 메서드를 통해 우 방향을 가진 Direction 을 생성한다.")
    void of2() {
        assertThat(Direction.of(FALSE, TRUE).isLeft()).isFalse();
        assertThat(Direction.of(FALSE, TRUE).isRight()).isTrue();
    }

    @Test
    @DisplayName("of 메서드를 통해 아무 방향이 없는 Direction 을 생성한다.")
    void of3() {
        assertThat(Direction.of(FALSE, FALSE).isLeft()).isFalse();
        assertThat(Direction.of(FALSE, FALSE).isRight()).isFalse();
    }

    @Test
    @DisplayName("of 메서드를 통해 양쪽 방향을 생성하면 Error 발생")
    void ofError() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Direction.of(TRUE, TRUE));
    }

    @Test
    @DisplayName("next 메서드를 통해 이전 방향과 이어진 다음 Direction 생성한다.")
    void next() {
        Direction firstDirection = Direction.of(FALSE, TRUE);
        Direction secondDirection = firstDirection.next(false);

        assertThat(secondDirection.isLeft()).isTrue();
    }
}
