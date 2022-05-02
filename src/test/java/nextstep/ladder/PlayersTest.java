package nextstep.ladder;

import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("사다리 타기 게임에 참가하는 모든 Player 를 관리하는 일급 콜렉션 생성")
    void createPlayers() {
        Players players = Players.create(asList("a", "b", "c", "d"));
        assertThat(players).isEqualTo(Players.create(asList("a", "b", "c", "d")));
    }
}