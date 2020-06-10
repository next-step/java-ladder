package ladder.domain.ladder.shape;

import ladder.domain.ladder.shape.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class HeightTest {

    @DisplayName("사다리의 높이 값이 1보다 작으면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Height.of(Height.MIN_HEIGHT - 1));
    }

    @DisplayName("사다리 높이 생성")
    @ParameterizedTest
    @ValueSource(ints = { Height.MIN_HEIGHT, 10, 100 })
    void create(final int height) {
        assertThatCode(() -> Height.of(height))
                .doesNotThrowAnyException();
    }

    @DisplayName("논리적 동치성 비교")
    @Test
    void equals() {
        assertThat(Height.of(Height.MIN_HEIGHT))
                .isEqualTo(Height.of(Height.MIN_HEIGHT));
    }
}
