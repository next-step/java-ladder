package nextstep.ladder.domain;

import nextstep.ladder.domain.play.PlayerPosition;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.GameResults;
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


    @DisplayName("Players객체, GameResults객체로 GameElement 객체를 만들 수 있다")
    @Test
    void should_make_GameElement_with_Players_GameResults_object() {
        //arrange
        Players players = Players.of(Arrays.asList("aa", "bbb"));
        GameResults gameResults = GameResults.of(Arrays.asList("11", "222"));

        //act, assert
        assertThat(GameElement.of(players, gameResults)).isInstanceOf(GameElement.class);
    }

    @DisplayName("Players가 null이면 IllegalArgumentException이 발생한다")
    @Test
    void should_throw_exception_when_players_null() {
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

    @DisplayName("Players를 반환한다")
    @Test
    void should_return_players() {
        //arrange
        GameElement gameElement = makeGameElement();

        //act
        Players players = gameElement.getPlayers();

        //assert
        assertThat(players.getNames()).containsAll(Arrays.asList("aa", "bbb"));
    }

    @DisplayName("GameResults를 반환한다")
    @Test
    void should_return_GameResults() {
        //arrange
        GameElement gameElement = makeGameElement();

        //act
        GameResults result = gameElement.getGameResults();

        //assert
        assertThat(result.getGameResultValues()).containsAll(Arrays.asList("11", "222"));
    }

    @DisplayName("Player수를 반환한다")
    @Test
    void should_return_count_of_player() {
        //arrange
        GameElement gameElement = makeGameElement();

        //act
        int count = gameElement.getPlayerCount();

        //assert
        assertThat(count).isEqualTo(2);
    }

    @DisplayName("Player Postion에 맞는 이름을 반환한다")
    @Test
    void should_return_player_name_at_position() {
        //arrange
        GameElement gameElement = makeGameElement();
        PlayerPosition position = PlayerPosition.of(0);

        //act
        String name = gameElement.getPlayerNameAt(position);

        //assert
        assertThat(name).isEqualTo("aa");
    }

    @DisplayName("Player Postion에 맞는 result를 반환한다")
    @Test
    void should_return_player_resut_at_position() {
        //arrange
        GameElement gameElement = makeGameElement();
        PlayerPosition position = PlayerPosition.of(0);

        //act
        String result = gameElement.getResultAt(position);

        //assert
        assertThat(result).isEqualTo("11");
    }

    private GameElement makeGameElement() {
        List<String> playerNames = Arrays.asList("aa", "bbb");
        List<String> gameResults = Arrays.asList("11", "222");
        return GameElement.of(playerNames, gameResults);
    }

}