package ladder;

import ladder.domain.Line;
import ladder.domain.LineShuffleGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsShuffleGeneratorTest {

    private LineShuffleGenerator lineShuffleGenerator;

    @BeforeEach
    void setUp() {
        this.lineShuffleGenerator = new LineShuffleGenerator();
    }

    @Test
    void pointsShuffleTest() {
        assertThat(lineShuffleGenerator.generate(5)).isInstanceOf(Line.class);
        assertThat(lineShuffleGenerator.generate(5).getPoints()).hasSize(5);
    }
}
