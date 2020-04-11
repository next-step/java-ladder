package ladder.domain.row;

import ladder.model.row.Point;
import ladder.model.row.Position;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PointTest {
    @DisplayName("최초 Position의 사다리 게임 후, 최종 포지션을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:1"}, delimiter = ':')
    void findFinalPosition(int initialPosition, int finalPosition) {
        //given
        Point initialPoint = Point.of(Position.of(initialPosition));
        Rows rows = Rows.of(Arrays.asList(createFirstRow(), createSecondRow()));

        //then
        initialPoint.move(rows);

        //then
        Assertions.assertThat(initialPoint.getFinalPosition()).isEqualTo(Position.of(finalPosition));
    }

    private Row createFirstRow() {
        Map<Position, Boolean> row = new HashMap<>();
        row.put(Position.of(0), true);
        row.put(Position.of(1), false);
        return new Row(row);
    }

    private Row createSecondRow() {
        Map<Position, Boolean> row = new HashMap<>();
        row.put(Position.of(0), false);
        row.put(Position.of(1), true);
        return new Row(row);
    }
}