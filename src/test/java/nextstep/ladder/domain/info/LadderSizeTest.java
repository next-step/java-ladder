package nextstep.ladder.domain.info;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderSizeTest {

    @DisplayName("가로 세로 정보로 LadderSize를 만든다")
    @Test
    void should_make_with_width_height() {
        //arrange, act, assert
        assertThat(LadderSize.of(1, 1)).isInstanceOf(LadderSize.class);
    }

    @DisplayName("with, height가 최소값인 1 이하이면 IllegalArgumentException을 던진다")
    @CsvSource(value = {"1,0", "0,1"}, delimiter = ',')
    @ParameterizedTest
    void throw_exception_when_below_min_width_or_height(int width, int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderSize.of(width, height));
    }

}