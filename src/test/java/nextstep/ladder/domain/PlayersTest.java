package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @DisplayName("참여자 이름을 받아 참여자를 생성한다")
    @Test
    void create() {
        List<String> playerNames = List.of("pobi", "crong", "honux");
        Players players = Players.of(playerNames);

        assertThat(players.countOfPerson()).isEqualTo(playerNames.size());
    }

    @DisplayName("참가자는 1명 이상이다")
    @Test
    void invalidPlayerCount() {
        assertThatThrownBy(() -> Players.of(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
