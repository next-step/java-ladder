package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("참가자 객체 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        Player player = new Player("a");

        //then
        assertThat(player.getName()).isEqualTo("a");
    }

}
