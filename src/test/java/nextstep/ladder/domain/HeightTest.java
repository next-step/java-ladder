package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {
    @Test
    @DisplayName("사다리 높이 객체 생성을 확인한다.")
    void checkedCreateLadderHight() {
        // given
        int value = 5;

        // when
        Height height = new Height(value);

        // then
        assertThat(height.getValue()).isEqualTo(value);
    }

    @Test
    @DisplayName("높이가 0이하일 경우, 예외처리를 해준다.")
    void exceptionLadderHeightUnderZero() {
        // given
        int value = 0;

        // when & then
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}