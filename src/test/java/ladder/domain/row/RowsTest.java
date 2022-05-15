package ladder.domain.row;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class RowsTest {
    @ParameterizedTest
    @NullAndEmptySource
    void Rows는_rows_없이_생성_할_경우_예외를_발생_시킨다(List<Row> rows) {
        assertThatThrownBy(
                () -> new Rows(rows)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateByWidthAndHeight는_ladderWidth와_ladderHeight로_Rows를_생성한다() {
        int ladderWidth = 4;
        int ladderHeight = 5;

        Rows rows = Rows.generateByWidthAndHeight(ladderWidth, ladderHeight);

        assertAll(
                () -> assertInstanceOf(Rows.class, rows)
        );
    }
}
