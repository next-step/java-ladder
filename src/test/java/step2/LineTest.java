package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("Line 클래스 생성 테스트")
    void createLine() {
        Line line = new Line();
        assertThat(line).isEqualTo(new Line());
    }

    @Test
    @DisplayName("같은 라인에서는 연속으로 줄이 만들어 질 수 없다")
    void existLine() {
        Line line = new Line();

        assertThat(line.isPoint(0, new NumberGenerator() {
            @Override
            public boolean number() {
                return false;
            }
        })).isEqualTo(new Point(false));
    }

    @Test
    @DisplayName("같은 라인에서는 연속으로 줄이 만들어 질 수 없다")
    void sameLineNotCreatedTest() {

    }
}
