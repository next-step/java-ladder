package ladder.domain;

import ladder.exception.PlayerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @DisplayName("Players 생성")
    @Test
    public void constructor_success() throws Exception {
        //then
        Players players = new Players(
                Arrays.asList(new Player("a"), new Player("B")));
    }

    @DisplayName("2명 미만의 Players 생성")
    @Test
    public void constructor_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new Players(Arrays.asList(new Player("a")))
        ).isInstanceOf(PlayerException.class);
    }
}
