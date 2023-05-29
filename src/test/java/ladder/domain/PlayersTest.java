package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayersTest {

    @Test
    void 참가자들_생성() {
        Players players = Players.create(FixtureForTest.namesFixture("김두한,구마적,신마적"));
        assertAll(
                () -> assertThat(players.count()).isEqualTo(3),
                () -> assertThat(players.getNames()).isEqualTo(FixtureForTest.namesFixture("김두한,구마적,신마적"))
        );
    }
}