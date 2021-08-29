package nextstep.ladder.domain;

import nextstep.ladder.domain.impl.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("string을 매개변수로 player를 생성한다.")
    @Test
    void create() {
        String name = "pobi";
        assertThat(Player.from(name)).isEqualTo(Player.from(name));
    }

    @DisplayName("player 이름은 5글자를 초과하면 안된다.")
    @Test
    void validPlayerNameLength() {
        String name = "pobipo";
        assertThatThrownBy(() -> Player.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("player 이름은 공백 혹은 NULL 이 위치하면 안된다.")
    @Test
    void validEmptyOrNull() {
        assertThatThrownBy(() -> Player.from(null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Player.from(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Player.from("        "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
