package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineBuilderTest {

    @DisplayName("사람 수를 받아 가로 라인을 생성한다")
    @Test
    void createLine() {
        Line line = LineBuilder.buildWithRandomPoints(5);
        assertThat(line.width()).isEqualTo(5);
    }
}
