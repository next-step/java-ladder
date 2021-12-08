package nextstep.ladder.model.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    @DisplayName("높이를 입력했을 때 생성 테스트")
    void createTest() {
        Height height = new Height("5");

        assertThat(height.getHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("높이를 문자로 입력했을 경우 예외 검증")
    void isNotDigitExceptionTest() {
        assertThatThrownBy(() ->
                new Height("test")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("높이를 10보다 크게 입력했을 경우 예외 검증")
    void heightExceptionTest() {
        assertThatThrownBy(() ->
                new Height("11")).isInstanceOf(IllegalArgumentException.class);
    }
}
