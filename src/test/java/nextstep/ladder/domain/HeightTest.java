package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class HeightTest {

    @DisplayName("사다리 높이 생성 테스트")
    @Test
    void create_높이() {
        // given
        Height height = Height.valueOf(10);
        // when
        Height expected = Height.valueOf(10);
        // then
        assertThat(height).isEqualTo(expected);
    }

    @DisplayName("사다리 높이 생성 예외처리")
    @Test
    void create_Exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Height.valueOf(-1));
    }
}
