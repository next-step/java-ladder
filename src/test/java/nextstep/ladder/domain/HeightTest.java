package nextstep.ladder.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class HeightTest {

    @ParameterizedTest(name = "높이 생성 - 부적절한 높이값인 경우 | {arguments}")
    @ValueSource(strings = {"-1", "0"})
    public void validHeight(int height) {
        // given
        String message = String.format("높이는 0보다 커야 합니다 -> %s", height);

        // when
        ThrowingCallable throwingCallable = () -> new Height(height);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getHeight 테스트")
    public void getHeight() {
        // given
        int heightInput = 3;
        int expected = 3;

        // when
        Height height = new Height(heightInput);

        // then
        assertThat(height).isNotNull();
        assertThat(height.getHeight()).isEqualTo(expected);
    }

}