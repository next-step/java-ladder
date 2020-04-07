package ladder.domain;

import ladder.exception.PlayerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("참가자 객체 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        Player player = new Player("a");

        //then
        assertThat(player.getName()).isEqualTo("a");
    }

    @DisplayName("참가자 객체 생성")
    @Test
    public void constructor_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new Player("123456")
        ).isInstanceOf(PlayerException.class);
    }
}
