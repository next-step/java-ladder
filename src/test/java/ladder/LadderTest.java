package ladder;

import ladder.dto.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LadderTest {

    @Test
    void 새로운_사다리라인_생성() {
        Line line = new Line(5);
        assertThat(line.getPoints().size()).isEqualTo(5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Line(-5);
                });
    }
}
