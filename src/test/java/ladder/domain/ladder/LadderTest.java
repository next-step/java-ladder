package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.point.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static ladder.domain.ladder.RowTest.LEFT_ROW;
import static ladder.domain.ladder.RowTest.RIGHT_ROW;
import static ladder.domain.ladder.RowTest.UNCONNECTED_ROW;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class LadderTest {
    @ParameterizedTest
    @NullAndEmptySource
    void Ladder는_rows_없이_생성_할_경우_예외를_발생_시킨다(List<Row> rows) {
        assertThatThrownBy(
                () -> new Ladder(rows)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateByWidthAndHeight는_width와_height로_Ladder를_생성한다() {
        int width = 4;
        int height = 5;

        Ladder ladder = Ladder.generateByWidthAndHeight(width, height);

        assertInstanceOf(Ladder.class, ladder);
    }

    @Test
    void trace는_player를_사다리를_따라서_이동된_위치를_반환한다() {
        Player player = new Player("name", 2);
        Ladder ladder = new Ladder(List.of(
                RIGHT_ROW,
                UNCONNECTED_ROW,
                LEFT_ROW,
                LEFT_ROW
        ));

        Position movedPosition = ladder.trace(player);

        assertEquals(movedPosition, new Position(1));
    }
}
