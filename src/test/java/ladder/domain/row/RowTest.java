package ladder.domain.row;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RowTest {
    @Test
    void Row는_points_없이_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Row(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateByWidth은_ladderWidth로_Row를_생성한다() {
        int ladderWidth = 5;

        Row row = Row.generateByWidth(ladderWidth);

        assertAll(
                () -> assertEquals(ladderWidth, row.width()),
                () -> assertInstanceOf(Row.class, row)
        );
    }
}
