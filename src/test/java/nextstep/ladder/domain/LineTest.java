package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @DisplayName("높이에 맞는 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void createLine(int height) {
        Line line = Line.of(height);

        assertThat(line.getLineHeight()).isEqualTo(height);
    }
}
