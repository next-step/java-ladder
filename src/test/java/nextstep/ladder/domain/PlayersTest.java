package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class PlayersTest {

    @DisplayName("참여자 이름을 받아 참여자를 생성한다")
    @Test
    void create() {
        List<String> playerNames = List.of("pobi", "crong", "honux");
        Players players = Players.of(playerNames);

        assertThat(players.count()).isEqualTo(playerNames.size());
    }

    @DisplayName("참가자는 1명 이상이다")
    @Test
    void invalidPlayerCount() {
        assertThatThrownBy(() -> Players.of(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인덱스를 받아 참가자를 반환한다")
    @Test
    void getPlayer() {
        List<String> playerNames = List.of("pobi", "crong", "honux");
        Players players = Players.of(playerNames);

        assertSoftly(softAssertions -> {
            softAssertions.assertThat(players.getPlayer(0).getName()).isEqualTo("pobi");
            softAssertions.assertThat(players.getPlayer(1).getName()).isEqualTo("crong");
            softAssertions.assertThat(players.getPlayer(2).getName()).isEqualTo("honux");
        });
    }
}
