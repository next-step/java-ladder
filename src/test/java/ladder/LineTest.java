package ladder;

import ladder.dto.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 연속된_Point를_가질수_없다() {
        Line line = new Line(List.of(true, true, false));
        assertThat(line.validateBeforeIdxHasTrue(1)).isTrue();
    }
}
