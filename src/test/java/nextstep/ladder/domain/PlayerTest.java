package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

    @DisplayName("player는 5글자 이내의 이름을 가진다.")
    @ValueSource(strings = {
        "a",
        "aa",
        "aaa",
        "aaaa"
    })
    @ParameterizedTest
    void player_name_length(String name) {
        Player player = new Player(name);

        assertThat(player.getName()).isEqualTo(name);
    }

    @DisplayName("player는 이름이 5초과시 예외를 발생한다.")
    @ValueSource(strings = {
        "123456",
        "1234567"
    })
    @ParameterizedTest
    void given_more_than_5_when_crate_then_throw_exception(String name) {
        assertThatThrownBy(() -> new Player(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
