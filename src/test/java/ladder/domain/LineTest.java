package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    private Line line;

    class RandomDecisionTest implements BridgeDecision {
        private Boolean value;

        public RandomDecisionTest(Boolean value) {
            this.value = value;
        }

        @Override
        public Boolean isBridgeTarge() {
            return value;
        }
    }

    @BeforeEach
    void beforeEech() {
        line = new Line(5, true);
    }

    @Test
    void createLine_dotSize() {
        assertThat(line.getDots()).hasSize(5);
    }

    @Test
    void createLine_firstValueOfLine() {
        assertThat(line.getDots().get(0)).isTrue();
    }

    @Test
    void createLine_lastValueOfLine() {
        assertThat(line.getDots().get(4)).isFalse();
    }

    @Test
    void createLine_middleValueOfLine() {
        assertThat(!line.getDots().get(3)).isEqualTo(line.getDots().get(2));
    }
}
