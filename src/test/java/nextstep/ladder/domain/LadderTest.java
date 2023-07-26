package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    private Ladder ladder;
    private WinningItems winningItems;

    @BeforeEach
    void init() {
        Players players = new Players("kbc", "kbc1", "kbc2");
        List<Line> lines = List.of(
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(true), new Point(false))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true)))
        );
        ladder = new Ladder(lines, players);
        winningItems = new WinningItems(players.numberOfPlayers(), "꽝", "1000", "2000");
    }

    @Test
    void 높이_유효성_테스트() {
        Players players = new Players(List.of(Player.of("kbc"), Player.of("kbc2")));

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Ladder(0, players));
    }

    @Test
    void movePlayer_테스트() {
        PlayerWinnings playerWinnings = ladder.movePlayer("kbc", winningItems);

        String result = playerWinnings.toString();

        assertThat(result).isEqualTo("kbc: 2000");
    }

    @Test
    void movePlayerAll_테스트() {
        List<PlayerWinnings> playerWinnings = ladder.movePlayerAll(winningItems);

        String result = playerWinnings.toString();

        assertThat(result).isEqualTo("[kbc: 2000, kbc1: 꽝, kbc2: 1000]");
    }
}
