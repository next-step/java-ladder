package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {

    @DisplayName("높이 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createHeightTest(int size) {
        Height height = Height.of(size);
        assertThat(height).isEqualTo(Height.of(size));
        assertThat(height.getSize()).isEqualTo(Height.of(size).getSize());
    }

    @DisplayName("높이 객체 생성 예외처리 테스트")
    @Test
    void createHeightExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Height.of(0));
    }
}
