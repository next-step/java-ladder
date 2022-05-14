package ladder.domain.ladder;

import ladder.domain.player.Players;
import ladder.domain.row.Rows;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class LadderTest {
    @Test
    void Ladder는_players_없이_생성할_경우_예외를_발생시킨다() {
        assertThatThrownBy(
                () -> new Ladder(null, Rows.of(1, 1))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Ladder는_rows_없이_생성할_경우_예외를_발생시킨다() {
        assertThatThrownBy(
                () -> new Ladder(Players.from(List.of("name")), null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void of는_players와_height로_Ladder를_생성한다() {
        Players players = Players.from(List.of("name"));
        int height = 5;

        Ladder ladder = Ladder.of(players, height);

        assertAll(
                () -> assertInstanceOf(Ladder.class, ladder),
                () -> assertEquals(5, ladder.getRows().size()),
                () -> assertEquals(players.size(), ladder.getPlayers().size()),
                () -> assertEquals("name", ladder.getPlayers().getPlayers().get(0).toString())
        );
    }
}
