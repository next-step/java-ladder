package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        GameManager gameManager = GameManager.of(gameResults);
        List<GameResult> actual = gameManager.getResult("all");
        assertAll(
                () -> assertThat(actual.get(0)).isEqualTo(GameResult.of(User.of("pobi"),"꽝")),
                () -> assertThat(actual.get(1)).isEqualTo(GameResult.of(User.of("honux"),"5000")),
                () -> assertThat(actual.get(2)).isEqualTo(GameResult.of(User.of("crong"),"3000")),
                () -> assertThat(actual.get(3)).isEqualTo(GameResult.of(User.of("jk"),"꽝"))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
        "pobi&pobi : 꽝",
        "honux&honux : 5000",
        "crong&crong : 3000",
        "jk&jk : 꽝"
    }
    ,delimiter = '&')
    @DisplayName("GameManager 선택한 플레이어의 결과값 예상")
    void gameManager_getSelectResult_isEqualTo(String selectKey, String expect) {
        GameManager gameManager = GameManager.of(gameResults);
        List<GameResult> actual = gameManager.getResult(selectKey);
        assertThat(actual.get(0).toPrint()).isEqualTo(expect);
    }
}
