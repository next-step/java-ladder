package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @Test
    void create() {
        assertThat(Position.of(3)).isEqualTo(Position.of(3));
    }

    @DisplayName("현재 위치가 음수가 되면 예외를 발생시킨다.")
    @Test
    void 현재위치가_음수일떄() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Position.of(-1);
        });
    }

    @DisplayName("사다리의 이전의 길이 존재하면 포지션은 하나 감소한다.")
    @Test
    void 사다리_이전으로_이동() {
        final Position position = Position.of(1);
        assertThat(position.move(Arrays.asList(true, false, true))).isEqualTo(Position.of(0));
    }

    @DisplayName("사다리의 이후의 길이 존재하면 포지션은 하나 증가한다.")
    @Test
    void 사다리_이후으로_이동() {
        final Position position = Position.of(1);
        assertThat(position.move(Arrays.asList(false, true, true))).isEqualTo(Position.of(2));
    }

    @DisplayName("사다리의 이전, 이후의 길이 존재하지 않으면 포지션은 그대로 유지한다.")
    @Test
    void 사다리_이동안함() {
        final Position position = Position.of(1);
        assertThat(position.move(Arrays.asList(false, false, true))).isEqualTo(Position.of(1));
    }

    @DisplayName("사다리의 첫번쨰 라인이면 True를 리턴한다.")
    @Test
    void 포지션이_라인_첫번째_일떄() {
        final Position position = Position.of(0);
        assertThat(position.isFirstPosition()).isTrue();
    }

    @DisplayName("사다리의 마지막 라인이면 True를 리턴한다.")
    @Test
    void 포지션이_라인_마지막_일떄() {
        final Position position = Position.of(3);
        assertThat(position.isLastPosition(Arrays.asList(true, false, true))).isTrue();
    }
}