package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Height;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    @DisplayName("사다리 높이 클래스 생성")
    void createHeight() {
        Height height = new Height(3);
        assertThat(height).isEqualTo(new Height(3));
    }

    @Test
    @DisplayName("사다리의 높이가 최소 높이보다 작으면 예외를 발생시키는 테스트")
    void heightExceptionTest() {
        assertThatThrownBy(() -> new Height(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
