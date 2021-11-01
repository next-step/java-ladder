package ladder.domain;

import ladder.engine.LineCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeeSeokLineCreatorTest {

    @Test
    @DisplayName("Line이 생성이 잘되는지 테스트")
    void create() {
        LineCreator lineCreator = new LineCreator() {
            @Override
            public Line create(int sizeOfUsers) {
                boolean[] points = new boolean[]{true, true, true, false, true, false, true};
                return new Line(sizeOfUsers, points);
            }
        };

        Line lines = lineCreator.create(4);
        assertThat(lines.points()).containsExactly(true, true, true, false, true, false, true);
    }
}
