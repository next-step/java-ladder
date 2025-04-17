package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @Test
    void createTest() {
        LadderGame ladderGame = new LadderGame(List.of("pobi", "honux", "crong", "jk"), 5,
                new FakeGeneratorStrategy(true));

        assertThat(ladderGame).isNotNull();
    }

    @Test
    void getPlayersTest() {
        LadderGame ladderGame = new LadderGame(List.of("pobi", "honux", "crong", "jk"), 5,
                new FakeGeneratorStrategy(true));

        assertThat(ladderGame.getPlayers()).isEqualTo(
                List.of(
                        new Player("pobi", 0),
                        new Player("honux", 1),
                        new Player("crong", 2),
                        new Player("jk", 3)
                ));
    }

    @Test
    void getLinesTest() {
        LadderGame ladderGame = new LadderGame(List.of("pobi", "honux", "crong", "jk"), 5,
                new FakeGeneratorStrategy(true));

        assertThat(ladderGame.getLines()).isEqualTo(
                List.of(
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true))
                ));
    }

    @Test
    void progressGameTest() {
        LadderGame ladderGame = new LadderGame(List.of("pobi", "honux", "crong", "jk"), 5,
                new FakeGeneratorStrategy(true));

        List<Player> players = ladderGame.progressGame();

        assertAll(() -> assertThat(players.get(0)).isEqualTo(new Player("pobi", 1)),
                () -> assertThat(players.get(1)).isEqualTo(new Player("honux", 0)),
                () -> assertThat(players.get(2)).isEqualTo(new Player("crong", 3)),
                () -> assertThat(players.get(3)).isEqualTo(new Player("jk", 2)));
    }
}
