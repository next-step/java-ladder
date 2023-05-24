package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @DisplayName("Position 값은 음수일 수 없다.")
    @Test
    void 사다리게임_위치값_음수() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Position.create(-1))
                .withMessageMatching("위치값은 음수일 수 없습니다.");
    }

    @DisplayName("우측 이동 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 우측_이동의_경우(int input) {
        Position position = Position.create(input);
        assertThat(position.moveToRight()).isEqualTo(input + 1);
    }

    @DisplayName("좌측 이동 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 좌측_이동의_경우(int input) {
        Position position = Position.create(input);
        assertThat(position.moveToLeft()).isEqualTo(input - 1);
    }
}
