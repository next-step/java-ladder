package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @DisplayName("입력한 width 의 개수만큼의 Point list 생성")
    void createLineTest(int width) {
        Line of = Line.of(width, () -> true);
        assertThat(of.getPoints()).hasSize(width);
    }
}