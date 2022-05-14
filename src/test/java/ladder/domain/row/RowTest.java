package ladder.domain.row;

import org.junit.jupiter.api.Test;

import static ladder.domain.row.Row.ROW_START_INDEX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RowTest {
    @Test
    void Row는_steps_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Row(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void from은_playerSize로_Row를_생성한다() {
        int playerSize = 5;

        Row row = Row.from(playerSize);

        assertAll(
                () -> assertEquals(playerSize - ROW_START_INDEX, row.getSteps().size()),
                () -> assertInstanceOf(Row.class, row)
        );
    }
}
