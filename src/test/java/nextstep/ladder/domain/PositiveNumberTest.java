package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {
    @Test
    @DisplayName("성공 - getValue메서드가 value를 반환한다.")
    void initLadderTest() {
        PositiveNumber height = new PositiveNumber(1);
        assertThat(height.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("성공 - PositiveNumber 객체가 동등성을 보장한다.")
    void equalsTest() {
        PositiveNumber height1 = new PositiveNumber(1);
        PositiveNumber height2 = new PositiveNumber(1);
        assertThat(height1).isEqualTo(height2);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("실패 - PositiveNumber 객체를 생성할 때 매개변수가 0이하일 경우 예외가 발생한다.")
    void throwExceptionWhenLadderHeightIsZeroOrNegative(int height) {
        assertThatThrownBy(() -> new PositiveNumber(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 이하일 수 없습니다.");
    }
}