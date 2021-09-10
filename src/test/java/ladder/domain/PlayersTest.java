package ladder.domain;

import ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @DisplayName("생성")
    @Test
    void create() {
        String[] splitPlayers = "jenny,jisu,risa,rose".split(",");
        Players players = new Players(splitPlayers);
        assertThat(players.size()).isEqualTo(splitPlayers.length);
    }

    @DisplayName("플레이어 수가 두 명 미만일 때 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfInputSizeUnderTwo() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Players(StringUtil.split("jeny"))
        );
    }

    @DisplayName("Position이 Player 숫자 내의 값을 가질 때 Player 반환")
    @Test
    void find_ReturnPlayer_IfPositionIsInRangeOfPlayerSize() {
        String[] splitPlayers = "jenny,jisu,risa,rose".split(",");
        Players players = new Players(splitPlayers);
        Player player = players.find(new Position(1));

        assertThat(player).isEqualTo(new Player("jisu"));
    }

    @DisplayName("입력 이름이 Players 내에 이름이 존재할 시 해당 Player를 찾아서 반환")
    @Test
    void find_ReturnPlayer_IfInputNameIsInPlayers() {
        String[] splitPlayers = "jenny,jisu,risa,rose".split(",");
        Players players = new Players(splitPlayers);
        Player player = players.find(new Name("jisu"));

        assertThat(player).isEqualTo(new Player("jisu"));
    }
}