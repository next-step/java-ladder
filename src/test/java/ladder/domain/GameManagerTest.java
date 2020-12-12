package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameManagerTest {

    private List<GameResult> gameResults;

    @BeforeEach
    void setUp() {
        this.gameResults = Arrays.asList(
                GameResult.of(User.of("pobi"),"꽝"),
                GameResult.of(User.of("honux"),"5000"),
                GameResult.of(User.of("crong"),"3000"),
                GameResult.of(User.of("jk"),"꽝")
        );
    }

    @Test
    @DisplayName("GameManager getResult() 전체 결과값 확인")
    void gameManager_getResultAll_isEqualTo() {
        GameManager gameManager = GameManager.of(GameResults.of(gameResults));
        List<GameResult> actual = gameManager.getResult(GameManager.DEFAULT_KEY);
        assertAll(
                () -> assertThat(actual.get(0)).isEqualTo(GameResult.of(User.of("pobi"),"꽝")),
                () -> assertThat(actual.get(1)).isEqualTo(GameResult.of(User.of("honux"),"5000")),
                () -> assertThat(actual.get(2)).isEqualTo(GameResult.of(User.of("crong"),"3000")),
                () -> assertThat(actual.get(3)).isEqualTo(GameResult.of(User.of("jk"),"꽝"))
        );
    }
}
