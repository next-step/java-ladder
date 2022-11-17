package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @DisplayName("라인수 확인")
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    public void lineCount(final int countPerson) {
        final Line line = new Line(countPerson);
        assertThat(line.getPoints()).hasSize(countPerson);
    }
}