package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @Test
    void 연결방향정보생성() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    void 연결은한쪽만_가능하다() {
        assertThatThrownBy(() -> {
            Direction.of(TRUE, TRUE);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("연결되지 않은 왼쪽과 연결될 오른쪽을 가지는 다음 방향을 생성")
    void 다음방향을연결() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    @DisplayName("연결된 왼쪽과 연결되지 않을 오른쪽을 가지는 다음 방향을 생성")
    void 다음방향을연결하지않음() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    void 처음방향생성() {
        Direction first = Direction.first(TRUE);
        assertThat(first).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @Test
    void 마지막방향생성() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @Test
    @DisplayName("왼쪽 방향이 TRUE면 다음 생성되는 오른쪽 방향은 무조건 FALSE이다.")
    void 랜더방향생성_shouldFalse_true() {
        Direction nextTrue = Direction.of(FALSE, TRUE).next(() -> true);
        assertThat(nextTrue.isRight()).isFalse();
    }

    @Test
    @DisplayName("왼쪽 방향이 TRUE면 다음 생성되는 오른쪽 방향은 무조건 FALSE이다.")
    void 랜더방향생성_shouldFalse_false() {
        Direction nextFalse = Direction.of(FALSE, TRUE).next(() -> false);
        assertThat(nextFalse.isRight()).isFalse();
    }

    @Test
    @DisplayName("왼쪽방향이 FALSE일때 TRUE로 생성하는 전략을 테스트")
    void 랜덤방향생성_true() {
        Direction nextTrue = Direction.of(TRUE, FALSE).next(() -> true);
        assertThat(nextTrue.isRight()).isTrue();
    }

    @Test
    @DisplayName("왼쪽방향이 FALSE일때 FALSE로 생성하는 전략을 테스트")
    void 랜덤방향생성_false() {
        Direction nextFalse = Direction.of(TRUE, FALSE).next(() -> false);
        assertThat(nextFalse.isRight()).isFalse();
    }
}
