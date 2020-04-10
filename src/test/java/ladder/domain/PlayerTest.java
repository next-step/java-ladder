package ladder.domain;

import ladder.exception.PlayerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    public static Player A = new Player(0, "a");
    public static Player B = new Player(1, "b");

    @DisplayName("참가자 객체 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        Player player = new Player(0, "a");

        //then
        assertThat(player.getName()).isEqualTo("a");
    }

    @DisplayName("참가자의 이름은 5글자 이하여야 한다")
    @Test
    public void constructor_fail() throws Exception {
        //then
        assertThatThrownBy(
                () -> new Player(0, "aaaaaa")
        ).isInstanceOf(PlayerException.class);
    }
}
