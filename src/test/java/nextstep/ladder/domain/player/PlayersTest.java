package nextstep.ladder.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static nextstep.ladder.domain.player.Player.NAME_LENGTH_LIMIT;
import static nextstep.ladder.fixture.LadderFixture.DELIMITER;
import static nextstep.ladder.fixture.LadderFixture.INPUT_PLAYER_NAMES_FIXTURE;

class PlayersTest {
    @Test
    void getNames() {
        Players players = Players.from(stream(INPUT_PLAYER_NAMES_FIXTURE.split(DELIMITER))
                                               .collect(Collectors.toUnmodifiableList()));

        Assertions.assertThat(players.getNames())
                  .filteredOn(name -> name.length() <= NAME_LENGTH_LIMIT);
    }
}
