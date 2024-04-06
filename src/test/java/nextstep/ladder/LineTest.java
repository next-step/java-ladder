package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LineTest {

    @DisplayName("사람 수를 받아 가로 라인을 생성한다")
    @Test
    void createLine() {
        assertThatCode(() -> Line.createLine(5)).doesNotThrowAnyException();
    }
}
