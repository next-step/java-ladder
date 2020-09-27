package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class PlayersTest {

    private List<Player> playerList;

    @BeforeEach
    private void setUp() {
        this.playerList = Arrays.asList(
                Player.of("pobi", Lane.of(0)),
                Player.of("crong", Lane.of(1)),
                Player.of("jk", Lane.of(2)),
                Player.of("honux", Lane.of(3))
        );
    }

    @Test
    @DisplayName("문자열에 해당되는 Player 반환 메소드")
    void find() {
        Players players = new Players(playerList);
        Player actual = players.find("jk");
        assertTrue(actual.isSameName("jk"));
    }

    @Test
    @DisplayName("존재하지 않는 이름 예외 발생")
    void find_validateName() {
        Players players = new Players(playerList);
        assertThatIllegalArgumentException().isThrownBy(() ->
                players.find("sangiji")
        );
    }
}
