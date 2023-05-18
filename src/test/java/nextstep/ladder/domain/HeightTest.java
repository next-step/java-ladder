package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @DisplayName("높이가 1보다 작을경우 예외를 발생한다.")
    @Test
    void when_HeightIsUnderOne_Expects_ThrowException() {

        assertThatThrownBy(() -> Height.of(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 1보다 같거나 큰 경우 예외를 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void when_HeightIsUnderOne_Expects_ThrowException(int height) {

        assertThatNoException()
                .isThrownBy(() -> Height.of(height));
    }
}