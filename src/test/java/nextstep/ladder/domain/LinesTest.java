package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @ParameterizedTest
    @DisplayName("라인들은 사다리 높이 개만큼 존재(5 => 5)")
    @ValueSource(ints = {5, 6})
    void lines_size(int heightSize) {
        Lines lines = new Lines(new Height(heightSize), new Participant("a,b"));
        assertThat(lines.getSize()).isEqualTo(heightSize);
    }
}
