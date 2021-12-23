package rick.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PointTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("생성 테스트")
    void create(boolean input) {
        assertThat(new Point(input)).isEqualTo(new Point(input));
    }
}
