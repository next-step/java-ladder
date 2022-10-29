package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OrderPositionTest {

    @Test
    void shouldOrder() {
        List<Position> userPositions = List.of(new Position(3), new Position(2), new Position(1));
        List<Position> resultPositions = List.of(new Position(1), new Position(2), new Position(3));

        List<Map.Entry<Position, Position>> result = OrderPosition.order(userPositions, resultPositions);

        assertThat(result).containsExactly(
                Map.entry(new Position(1), new Position(3)),
                Map.entry(new Position(2), new Position(2)),
                Map.entry(new Position(3), new Position(1))
        );
    }

}
