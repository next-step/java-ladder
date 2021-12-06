package ladder.domain;

import ladder.domain.PlayerName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {

    @Test
    @DisplayName("선수이름 생성")
    void create() {
        PlayerName name = new PlayerName("kang");
        assertThat(name).isEqualTo(new PlayerName("kang"));
    }

    @Test
    @DisplayName("선수이름 검증 0이하 5자 초과시 -> IllegalArgumentException")
    void checkName() {
        assertThatThrownBy(() -> new PlayerName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PlayerName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}