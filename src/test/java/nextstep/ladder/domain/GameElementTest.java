package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameElementTest {

    @DisplayName("Players, GameResults GameElement 객체를 만들 수 있다")
    @Test
    void should_make_GameElement() {
        //arrange
        List<String> playerNames = Arrays.asList("aa", "bbb");
        List<String> gameResults = Arrays.asList("11", "222");

        //act, assert
        assertThat(GameElement.of(playerNames, gameResults)).isInstanceOf(GameElement.class);
    }

    @DisplayName("Players가 null이면 IllegalArgumentException이 발생한다")
    @Test
    void should_throw_exception_when_players_null() {
        //arrange
        //arrange
        List<String> playerNames = Arrays.asList("aa", "bbb");
        List<String> gameResults = null;

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> GameElement.of(playerNames, gameResults));
    }

    @DisplayName("gameResults가 null이면 IllegalArgumentException이 발생한다")
    @Test
    void should_throw_exception_when_gameResults_null() {
        //arrange
        List<String> playerNames = null;
        List<String> gameResults = Arrays.asList("11", "222");

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> GameElement.of(playerNames, gameResults));
    }

}