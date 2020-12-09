package ladder.domain.ladder;

import ladder.domain.util.RightPointRandom;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineTest {
    Line line;

    @BeforeEach
    void before() {
        line = new Line(5, new RightPointRandom());
    }

    @Test
    void getLineSize() {
        Assertions.assertThat(line.getSize()).isEqualTo(5);
    }

    @Test
    void getIsLeft() {
        Assertions.assertThat(line.isLeft(0)).isEqualTo(false);
    }

}