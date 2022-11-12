package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void lineGenerationTest() {
        Line line = new Line(3) {
            @Override
            protected boolean isConnectable(Random random, int frontIndex) {
                return true;
            }
        };

        line.generateConnection();
        assertThat(line.getPointSize()).isEqualTo(3);
        assertThat(line.getPoints()).containsOnly(true);
    }

}
