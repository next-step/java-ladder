package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineMaterialTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000})
    @DisplayName("Point size 는 0 이상의 양의 정수만 가능")
    void create(int value) {
        LineMaterial lineMaterial = LineMaterial.of(value, () -> true);

        assertThat(lineMaterial).isNotNull();
    }

    @Test
    @DisplayName("Point size 는 0 이상의 양의 정수만 가능")
    void exceptByCreation() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LineMaterial.of(-1, () -> true);
        }).withMessage(String.format("Point 수는 1 이상의 양의 정수만 가능합니다 (%d)", -1));
    }

}
