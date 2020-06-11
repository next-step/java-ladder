package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Height 클래스 추가")
class HeightTest {

    @DisplayName("1 이상의 Height 객체를 생성할 수 있다.")
    @Test
    void create() {
        int count = 1;
        Height height = new Height(count);

        assertThat(height.getHeight()).isEqualTo(count);
    }

    @DisplayName("1보다 작을 경우 예외를 반환한다.")
    @Test
    void validate() {
        int count = 0;
        assertThatExceptionOfType(HeightLengthException.class)
                .isThrownBy(() -> new Height(count))
                .withMessage(HeightLengthException.MESSAGE);

    }
}
