package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void create() {
        Players players = Players.create(FixtureForTest.namesFixture("김두한,구마적,신마적"));
        assertThat(players.count()).isEqualTo(3);
        assertThat(players.getNames()).isEqualTo(FixtureForTest.namesFixture("김두한,구마적,신마적"));

    }

    @Test
    void getNames() {
    }

    @Test
    void count() {
    }
}