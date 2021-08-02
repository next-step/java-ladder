package nextstep.ladder;

import nextstep.ladder.exception.IllegalPlayerNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("플레이어 이름은 5글자를 넘을 수 없다.")
    @Test
    void player_name_validation() {
        assertThatThrownBy(() -> Player.of("123456"))
                .isInstanceOf(IllegalPlayerNameSizeException.class);
    }
}