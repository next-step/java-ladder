package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.step2.domain.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PlayerTest {

    @Test
    @DisplayName("게임 플레이어 생성")
    void create_player() {
        final var player = new Player("choe");
        assertAll(
            () -> assertThat(player).isEqualTo(new Player("choe")),
            () -> assertThat(player).hasSameHashCodeAs(new Player("choe"))
        );
    }

    @Test
    @DisplayName("name 인자로 공백이 들어가는 경우")
    void create_player_name_length_0() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(""));
    }

    @Test
    @DisplayName("name 이 5자 초과")
    void create_player_name_length_6() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("choebk"));
    }
}
