package nextstep.ladder.domain.player;

import nextstep.ladder.dto.PlayerDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    @DisplayName("참가자 이름으로 검색한다.")
    void searchPlayerByName() {
        List<String> playerNameList = Arrays.asList("pobi", "honux", "crong", "jk");

        Players players = Players.of(playerNameList);
        PlayerDto jk = players.searchBy("jk")
                              .export();
        assertThat(jk.getName()).isEqualTo("jk");
    }

    @Test
    @DisplayName("주어진 이름을 가진 참가자가 없으면 예외 처리한다.")
    void throwExceptionIfPlayerThatHasNameNotExist() {
        List<String> playerNameList = Arrays.asList("pobi", "honux", "crong", "jk");
        Players players = Players.of(playerNameList);

        assertThatThrownBy(() -> players.searchBy("tdd")).isInstanceOf(RuntimeException.class);
    }
    
}
