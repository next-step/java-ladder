package ladder.domain;

import org.assertj.core.api.Assertions;
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
        assertThat(line.lineValues).hasSize(5);
    }

    @Test
    void createLine_firstValueOfLine() {
        assertThat(line.lineValues.get(0)).isTrue();
    }

    @Test
    void createLine_lastValueOfLine() {
        assertThat(line.lineValues.get(4)).isFalse();
    }

    @Test
    void createLine_middleValueOfLine() {
        assertThat(!line.lineValues.get(3)).isEqualTo(line.lineValues.get(2));
    }

    @Test
    void getShapeOfValue_true() {
        assertThat(line.getShapeOfValue(line.lineValues.get(0))).isEqualTo("|-----");
    }

    @Test
    void getShapeOfValue_false() {
        assertThat(line.getShapeOfValue(line.lineValues.get(4))).isEqualTo("|     ");
    }
}
