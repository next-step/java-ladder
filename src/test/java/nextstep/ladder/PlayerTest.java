package nextstep.ladder;

import nextstep.ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"asdfgh", "사다리게임중"})
    @DisplayName("플레이어 이름이 5글자를 초과하면 exception이 발생한다.")
    void player_name_length_valid_test(String name) {
        assertThatThrownBy(() ->
                new Player(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}