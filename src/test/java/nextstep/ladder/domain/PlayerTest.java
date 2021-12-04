package nextstep.ladder.domain;

import nextstep.ladder.exception.PlayerNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @ParameterizedTest
    @DisplayName("1~5자의 이름으로 Playr를 생성한다")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void createPlayer(String name) {
        assertThat(Player.from(name)).isInstanceOf(Player.class);
    }

    @ParameterizedTest
    @DisplayName("Player의 이름이 5자를 초과하면 예외가 발생한다")
    @ValueSource(strings = {"abcdef", "abcdefg"})
    void nameLengthException(String name) {
        assertThatThrownBy(() -> Player.from(name)).isInstanceOf(PlayerNameException.class);
    }

    @ParameterizedTest
    @DisplayName("Player의 이름이 없으면 예외가 발생한다")
    @NullAndEmptySource
    void nameEmptyException(String name) {
        assertThatThrownBy(() -> Player.from(name)).isInstanceOf(PlayerNameException.class);
    }

}