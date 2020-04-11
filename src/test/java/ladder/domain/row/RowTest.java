package ladder.domain.row;

import ladder.model.row.Position;
import ladder.model.row.Row;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @DisplayName("이전 값이 true면, 다음 값은 true가 오지 않는 Row 객체를 생성한다.")
    @Test
    void createTest() {
        //given
        int playerCount = 5;

        //when
        Row row = Row.create(playerCount);

        //then
        for (int i = 1; i < playerCount - 1; i++) {
            if (row.getRowElement(new Position(i))) {
                assertThat(row.getRowElement(new Position(i - 1))).isFalse();
            }
        }
    }

    @DisplayName("position 값을 주면, 해당 위치에 true/false 중 어떤 값이 있는지 반환")
    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
    void getRowElement(int position, boolean expected) {
        //given
        Row row = createOneRow();

        //when
        boolean rowElement = row.getRowElement(Position.of(position));

        //then
        assertThat(rowElement).isEqualTo(expected);
    }

    private Row createOneRow() {
        Map<Position, Boolean> row = new HashMap<>();
        row.put(Position.of(0), true);
        row.put(Position.of(1), false);
        return new Row(row);
    }
}
