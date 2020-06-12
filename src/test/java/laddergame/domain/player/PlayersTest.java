package laddergame.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @DisplayName("인자로 받은 이름의 Player를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong"})
    void findByName(String name) {
        String[] names = new String[]{"pobi", "crong", "horox"};
        Players players = new Players(names);

        Player player = players.findByName(name);

        assertThat(player.getName()).isEqualTo(name);
    }

    @DisplayName("없는 이름으로 찾으려 하면 IllegalArgumentException Throw")
    @Test
    void findByNameThrowException() {
        String[] names = new String[]{"pobi", "crong", "horox"};
        Players players = new Players(names);

        assertThatThrownBy(() -> players.findByName("뽀삐"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 이름입니다. - " + "뽀삐");
    }
}
