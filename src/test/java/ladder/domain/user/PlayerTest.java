package ladder.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("선수 객체 생성")
    void create() {
        Player player = new Player("kang");
        assertThat(player).isEqualTo(new Player("kang"));
    }

}
