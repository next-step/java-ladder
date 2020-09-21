package nextstep.ladder.domain.ladderGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"yohan", "jo", "jayde", "tom"})
    @DisplayName("유저 이름은 5글자 까지 부여")
    void create(String input) {
        assertThat(Player.from(input)).isEqualTo(Player.from(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"nonoover5", "abcdefd", "", "123456"})
    @DisplayName("유저 이름이 존재하지 않거나 5자리를 초과할 경우 Exception")
    void exceptByCreation(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Player.from(input);
        });
    }
}
