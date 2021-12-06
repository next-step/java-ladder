package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5})
    @DisplayName("높이가 0 아래일 경우 예외 발생 테스트")
    void underZeroExceptionTest(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Height(value))
                .withMessage("최대 사다리 높이는 0 이상이여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("높이가 0 이상일 경우 정상적으로 객체 생성 테스트")
    void fromZeroObjectCreate(int value) {
        Height height = new Height(value);
        assertThat(height).isEqualTo(new Height(value));
    }
}