package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @ParameterizedTest(name = "좌표값 정상 생성 테스트")
    @ValueSource(ints = {1, 2, 3})
    void of(int position) {
        assertThat(Position.of(position).now()).isEqualTo(position);
    }

    @DisplayName("좌표값의 위치가 음수인 경우 예외 발생 테스트")
    @Test
    void negativeException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Position.of(-1))
                .withMessageContaining("0보다")
        ;
    }
}