package ladder.domain.ladder;

import ladder.domain.util.RightPointRandom;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    Line line;

    @BeforeEach
    void before() {
        line = new Line(5, () -> false);
    }

    @Test
    void getLineSize() {
        Assertions.assertThat(line.getSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 그리기 테스트")
    void getPoints() {
        line.getPoints().forEach(point -> {
            Assertions.assertThat(point.getDirection().isLeft())
                    .isFalse();
        });
    }
}
