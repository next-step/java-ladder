package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exception.InputInvalidException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.player.Player.NAME_LENGTH_LIMIT;
import static nextstep.ladder.fixture.LadderFixture.INPUT_ENDPOINTS_FIXTURE;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayersTest {
    @Test
    void getNames() {
        Players players = Players.from(INPUT_ENDPOINTS_FIXTURE);
        Assertions.assertThat(players.names()).filteredOn(name -> name.length() <= NAME_LENGTH_LIMIT);
    }

    @Test
    void initException() {
        assertAll(
                () -> Assertions.assertThatThrownBy(() -> Players.from(null))
                                .isInstanceOf(InputInvalidException.class)
                                .hasMessage("입력이 없습니다."),

                () -> Assertions.assertThatThrownBy(() -> Players.from("unknowninputs"))
                                .isInstanceOf(InputInvalidException.class)
                                .hasMessage("입력이 잘못됐습니다.")
        );
    }
}
