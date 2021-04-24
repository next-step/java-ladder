package finalRefactor;

import finalRefactor.domain.Direction;
import finalRefactor.domain.LadderLine;
import finalRefactor.domain.Point;
import finalRefactor.domain.PositionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Line;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 라인 하나 생성 테스트")
    void oneLineTest() {
        Line line = new Line(3);
        System.out.println(line);
        assertThat(line.row().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("첫번째 라인에 대한 포인트")
    void firstPoint() {
        LadderLine ladderLine = new LadderLine();
        assertThat(ladderLine.first(new PositionGenerator() {
            @Override
            public boolean generate() {
                return true;
            }
        })).isEqualTo(new Point(0, Direction.of(false, true)));
    }
}
