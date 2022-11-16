package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("이름 생성")
    @Test
    void name() {
        // given
        String name = "LEE";

        // when
        Player playerResult = new Player(name);

        // then
        assertThat(playerResult).isEqualTo(new Player("LEE"));
    }
}
