package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WidthGeneratorTest {
    @DisplayName("라인 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void testCreateLine(final int personCount) {
        WidthGenerator widthGenerator = new WidthGenerator(personCount);
        assertThat(widthGenerator.getWidthLines()).hasSize(4);
    }
}
