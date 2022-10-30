package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineCreatorTest {

    @DisplayName("사다리 가로 한줄을 생성한다.")
    @Test
    void create_line() {

        final Line line = LineCreator.create(5);

        assertThat(line.getPoints()).hasSize(5);
    }

    @DisplayName("사다리 가로 한줄을 생성한다.")
    @Test
    void move_line() {

        final Line line = LineCreator.create(5);
        for (Point point : line.getPoints()) {
            point.move();
        }
        assertThat(line.getPoints()).hasSize(5);
    }
}