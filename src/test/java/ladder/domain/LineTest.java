package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    private Line line  ;
    class DecisionFirstValueOfLine implements BridgeDecision{
        private Boolean value ;
        public DecisionFirstValueOfLine(Boolean value) {
            this.value = value;
        }
        @Override
        public boolean isBridgeTarge() {
            return value;
        }
    }

    @BeforeEach
    void beforeEech() {
        line = new Line(5,new DecisionFirstValueOfLine(true));
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

    @Test
    void getShapeOfValue_true() {
        assertThat(line.getShapeOfValue(line.getDots().get(0))).isEqualTo("|-----");
    }

    @Test
    void getShapeOfValue_false() {
        assertThat(line.getShapeOfValue(line.getDots().get(4))).isEqualTo("|     ");
    }
}
