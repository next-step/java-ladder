package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    void 새로운_라인_생성() {
        Line line = new Line(5);
        assertThat(line.getPoints().size()).isEqualTo(4);

        Line line2 = new Line(List.of(true, true));
        assertThat(line2.getPoints().size()).isEqualTo(2);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Line(-5);
                });
    }

    @Test
    void 연속된_Point를_가질수_없다() {
        Line line = new Line(List.of(true, true, false));
        assertThat(line.validateBeforeIdxHasTrue(1)).isTrue();
    }
}
