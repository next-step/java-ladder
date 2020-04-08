package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {
    @DisplayName("라인 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void testCreateLine(final int personCount) {
        LineGenerator lineGenerator = new LineGenerator(personCount);

        assertThat(lineGenerator.generate()).hasSize(4);
    }
}
