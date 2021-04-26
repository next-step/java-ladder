package nextstep.ladder;

import nextstep.model.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.constant.Constant.EMPTY_LADDER_STRING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    @DisplayName("사람의 이름은 5자까지")
    void playerNameLimit() {
        assertThatThrownBy(() -> {
            new Players(new String[]{"fiveoverbong", "big"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백으로 구분된 사용자들 출력")
    void playerNames() {
        String bong = "bong";
        String big = "big";
        Players players = new Players(new String[]{bong, big});
        assertThat(players.spacedNames()).isEqualTo(bong + EMPTY_LADDER_STRING + big);
    }
}
