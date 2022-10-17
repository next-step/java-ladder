package ladder.domain;

import ladder.factory.VerticalMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class VerticalLineTest {

    @Test
    void shouldMapToVertical() {
        HorizontalLine horizontalLine = new HorizontalLine(List.of(new LineUnit()));

        VerticalLine verticalLine = VerticalLine.mapHorizontalLineToVertical(List.of(horizontalLine), 0);

        assertThat(verticalLine.getLineUnits().size()).isEqualTo(1);
    }

    @Test
    void shouldMovePosition() {
        List<VerticalLine> verticalLine = getVerticalLines();
        LadderPosition position = new LadderPosition(0);

        verticalLine.get(0).move(position, new LadderLength(2));

        assertThat(position.getHorizontalPosition()).isEqualTo(1);
        assertThat(position.length()).isEqualTo(1);

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
        return VerticalMapper.map(List.of(horizontalLineA, horizontalLineB), 2);
    }

}
