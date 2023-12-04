package ladder2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PlayerTest {

    @Test
    @DisplayName("유저 이름은  1 ~ 5자이다. 5자 초과일시 예외가 발생한다")
    void create() {
        ladder.domain.Player player1 = ladder.domain.Player.from("1");
        ladder.domain.Player player2 = ladder.domain.Player.from("12345");

        Assertions.assertThat(player1).isEqualTo(ladder.domain.Player.from("1"));
        Assertions.assertThat(player2).isEqualTo(ladder.domain.Player.from("12345"));
        Assertions.assertThatThrownBy(() -> {
            ladder.domain.Player.from("123456");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "유저 이름은 null 이나 빈값인 경우 예외가 발생한다")
    @NullAndEmptySource
    void create_null_or_empty(String input) {
        Assertions.assertThatThrownBy(() -> {
            Player.from(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
