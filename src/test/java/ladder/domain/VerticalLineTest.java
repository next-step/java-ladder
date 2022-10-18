package ladder.domain;

import ladder.factory.LadderFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class VerticalLineTest {

    @Test
    void shouldMovePosition() {
        List<VerticalLine> verticalLine = getVerticalLines();
        HorizontalPosition horizontalPosition = new HorizontalPosition(0);
        LadderPosition position = new LadderPosition(horizontalPosition);

        verticalLine.get(0).move(position, new LadderLength(2));

        assertThat(position.getHorizontalPosition()).isEqualTo(new HorizontalPosition(1));
        assertThat(position.length()).isEqualTo(1);
    }

    @Test
    void shouldReturnSamePosition(){
        VerticalLine line = new VerticalLine(List.of(new LineUnit()), new HorizontalPosition(0));

        assertThat(line.isSamePosition(new HorizontalPosition(0))).isTrue();
        assertThat(line.isSamePosition(new HorizontalPosition(1))).isFalse();
    }

    /***
     * 테스트 케이스 사다리 모양
     * | ---- |
     * | ---- |
     */
    private List<VerticalLine> getVerticalLines() {
        LineUnit unitA = new LineUnit();
        LineUnit unitB = new LineUnit();
        unitA.addNext(unitB);
        HorizontalLine horizontalLineA = new HorizontalLine(List.of(unitA, unitB));
        HorizontalLine horizontalLineB = new HorizontalLine(List.of(unitA, unitB));
        return LadderFactory.verticalLines(List.of(horizontalLineA, horizontalLineB), 2);
    }

}
