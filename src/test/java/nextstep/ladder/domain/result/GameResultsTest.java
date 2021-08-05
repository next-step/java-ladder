package nextstep.ladder.domain.result;

import nextstep.ladder.domain.play.PlayerPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameResultsTest {

    @DisplayName("GameResults는 GameResult 리스트를 가지고 객체를 생성한다")
    @Test
    void should_make_game_results() {
        //arrange, act, assert
        assertThat(GameResults.of(Arrays.asList("a", "bb", "ccc"))).isInstanceOf(GameResults.class);
    }

    @DisplayName("GameResult 리스트가 null일경우 빈값일경우 경우 IllegalArgumentException을 발생시킨다")
    @Test
    void should_throw_exception() {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> GameResults.of(null));
    }

    @DisplayName("GameResult 값을 반환한다")
    @Test
    void should_return_game_result_values() {
        //arrange
        GameResults gameResults = GameResults.of(Arrays.asList("a", "bb", "ccc"));

        //act
        List<String> values = gameResults.getGameResultValues();

        //assert
        assertThat(values).containsExactly("a", "bb", "ccc");
    }

    @DisplayName("GameResult 값을 반환한다")
    @Test
    void should_return_game_result_with_position() {
        //arrange
        GameResults gameResults = GameResults.of(Arrays.asList("a", "bb", "ccc"));
        PlayerPosition playerPosition = PlayerPosition.of(0);

        //act
        String result = gameResults.getResultAt(playerPosition);

        //assert
        assertThat(result).isEqualTo("a");
    }

}