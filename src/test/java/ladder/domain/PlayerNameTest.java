package ladder.domain;

import ladder.domain.PlayerName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNameTest {

    @Test
    @DisplayName("선수이름 생성")
    void create() {
        PlayerName name = new PlayerName("kang");
        assertThat(name).isEqualTo(new PlayerName("kang"));
    }

}