package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {

    @Test
    @DisplayName("이름 목록을 입력받아 플레이어 객체들을 생성한다.")
    public void create() throws Exception {
        Players players = new Players("pobi", "dobi");
        List<Player> allPlayers = players.allPlayers();
        assertThat(allPlayers).containsExactly(new Player("pobi"), new Player("dobi"));
    }

    @Test
    @DisplayName("플레이어의 수를 반환한다.")
    public void countOfPlayer() throws Exception {
        Players players = new Players("pobi", "dobi");
        CountOfPlayer countOfPlayer = players.countOfPlayer();
        assertThat(countOfPlayer.number()).isEqualTo(2);
    }

    @Test
    @DisplayName("중복되는 이름을 가진 플레이어가 있을 경우 예외가 발생한다.")
    public void validateDuplication() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Players("pobi", "pobi"))
                .withMessage("중복되는 이름의 플레이어가 존재하는 지 확인해주세요.");
    }
}
