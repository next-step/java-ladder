package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @Test
    @DisplayName("두 개의 사다리는 연속되어 연결될 수 없다.")
    void canNotConnect() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("설정된 방향을 검증한다.")
    void setDirection() {
        assertThat(Direction.of(true, false).left()).isTrue();
        assertThat(Direction.of(true, false).right()).isFalse();
    }

    @Test
    @DisplayName("첫 사다리의 오른쪽 방향에 설정된 값을 검증한다.")
    void first() {
        assertThat(Direction.first(TRUE).right()).isTrue();
        assertThat(Direction.first(FALSE).right()).isFalse();
    }

    @Test
    @DisplayName("이전 사다리가 TRUE이면 다음 사다리는 FALSE로 설정된다.")
    void next() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next.right()).isFalse();
    }


    @Test
    @DisplayName("각 사다리는 연달아 이어질 수 없다.")
    void nextFromException() {
        assertThatThrownBy(() -> Direction.first(TRUE).next(TRUE))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("설정된 사다리의 방향을 검증한다.")
    void nextFrom() {
        Direction next = Direction.first(TRUE).next(FALSE);
        assertThat(next.left()).isTrue();
        assertThat(next.right()).isFalse();
    }

    @Test
    @DisplayName("마지막 사다리의 방향을 검증한다.")
    void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last.left()).isTrue();
        assertThat(last.right()).isFalse();
    }
}
