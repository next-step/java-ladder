package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionsTest {

    @Test
    @DisplayName("0 ~ 3 까지의 포지션 생성시 기본적인 포지션이 생성된다.")
    void createBasePositions() {
        Positions basePositions = Positions.createBasePositions(List.of(0, 1, 2, 3));

        List<Position> positions = List.of(new Position(0), new Position(1), new Position(2), new Position(3));
        assertThat(basePositions).isEqualTo(new Positions(positions));
    }

    @Test
    @DisplayName("최종 결과를 받을 경우 포지션의 위치가 변경된다.")
    void recordEndPosition() {
        Positions basePositions = Positions.createBasePositions(List.of(0, 1, 2, 3));

        List<Position> endPositions = List.of(new Position(2), new Position(3), new Position(4), new Position(5));
        basePositions.recordEndPosition(endPositions);

        assertThat(basePositions).isEqualTo(new Positions(endPositions));
    }
}