package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayersTest {
    @Test
    void 참가자리스트_null_excpetion() {
        assertThatIllegalArgumentException().isThrownBy(() -> Players.fromString(null));
    }

    @Test
    void toStringList() {
        Players players = Players.fromString(List.of("a", "b", "c"));
        assertThat(players.toStringList()).isEqualTo(List.of("a", "b", "c"));
    }
}