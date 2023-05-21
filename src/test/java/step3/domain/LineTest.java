package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("사다리 라인을 생성하고 검증한다. fakeMoveStrategy 가 false일 때 => false, true, false로 구성되어야 한다.")
    void createLine() {
        Line line = Line.createLine(3, new FakeMoveStrategy());
        assertThat(line.size()).isEqualTo(3);
        assertThat(line.getCurrent()).containsExactly(false, true, false);
    }
}