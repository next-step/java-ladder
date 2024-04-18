package ladder;

import ladder.domain.Line;
import ladder.domain.LineStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @Test
    void 라인_생성() {
        LineStrategy line = new Line(List.of(true, false, false, true));
        assertThat(line).isNotNull();
    }

    @Test
    void 올바르지_않은_라인_생성() {
        List<Boolean> connectedPoints = List.of(true, true);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(connectedPoints));
    }
}
