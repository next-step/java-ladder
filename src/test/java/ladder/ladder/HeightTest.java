package ladder.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {
    @DisplayName("사다리의 높이를 가진 객체를 생성할 수 있다.")
    @Test
    void create() {

        Height height = new Height(5);

        assertThat(height).isEqualTo(new Height(5));
    }

    @DisplayName("사다리의 높이가 1보다 작으면 에러로 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void heightThrowingException(int height) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(height));
    }
}
