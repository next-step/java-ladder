package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @DisplayName("이름과 높이를 가지는 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void createLine(int height) {
        Line line = Line.of(new Person("dong"), height);

        assertThat(line.getLineHeight()).isEqualTo(height);
    }
}
