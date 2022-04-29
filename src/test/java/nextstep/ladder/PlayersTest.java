package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("사다리 타기 게임에 참가하는 모든 Player 를 관리하는 일급 콜렉션 생성")
    void createPlayers() {
        Players players = Players.getNewInstanceByStrings(new String[]{"a", "b", "c", "d"});
        assertThat(players).isEqualTo(Players.getNewInstanceByStrings(new String[]{"a", "b", "c", "d"}));
    }
}