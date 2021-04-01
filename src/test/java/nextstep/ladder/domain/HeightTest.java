package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ParameterizedTest(name = "{0} 입력 시 예외 처리")
    @ValueSource(ints = {-1, 0})
    void create_Exception(int given) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Height.valueOf(given));
    }
}
