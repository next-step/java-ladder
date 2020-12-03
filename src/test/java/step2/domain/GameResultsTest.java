package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {
    private GameResults gameResults;

    @BeforeEach
    void setUp() {
        gameResults = GameResults.of(Arrays.asList(
                GameResult.of("a", "1"), GameResult.of("b", "2")));
    }


    @Test
    @DisplayName("플레이어들이 생성되는지 확인")
    void createPlayers() {
        //given
        assertThat(gameResults).isEqualTo(GameResults.of(Arrays.asList(
                GameResult.of("a", "1"), GameResult.of("b", "2"))));
    }

    @Test
    @DisplayName("플레이어가 리스트가 잘 생성되는지 확인")
    void createPlayersList() {
        //given
        assertThat(gameResults.getGameResults())
                .containsExactly(GameResult.of("a", "1"), GameResult.of("b", "2"));
    }

}