package nextstep.refactor_ladder.doamin;

import nextstep.refactor_ladder.domain.Line;
import nextstep.refactor_ladder.domain.generate.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("정상적으로 이동 검증")
    void move() {
        Line line = LineGenerator.create(5, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
    }
}
