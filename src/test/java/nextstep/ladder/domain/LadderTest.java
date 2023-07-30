package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void init() {
        Players players = new Players("kbc", "kbc1", "kbc2");
        List<Line> lines = List.of(
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(true), new Point(false))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true)))
        );
        ladder = new Ladder(lines, players.numberOfPlayers());
    }

    @Test
    void 높이_유효성_테스트() {
        Players players = new Players(List.of(Player.of("kbc"), Player.of("kbc2")));

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Ladder(0, players.numberOfPlayers()));
    }

    @Test
    void movePlayer_테스트() {
        MoveResult moveResult = ladder.movePlayer(0);

        assertThat(moveResult.getWinningItemIndex(0)).isEqualTo(2);
    }

    @Test
    void movePlayerAll_테스트() {
        MoveResult moveResult = ladder.movePlayer();

        assertThat(moveResult.getWinningItemIndex(0)).isEqualTo(2);
        assertThat(moveResult.getWinningItemIndex(1)).isEqualTo(0);
        assertThat(moveResult.getWinningItemIndex(2)).isEqualTo(1);
    }
}
