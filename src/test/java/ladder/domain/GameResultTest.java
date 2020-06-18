package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameResult 클래스 테스트")
class GameResultTest {

    @Test
    void create() {
        String name = "pobi";
        Reward reward = new Reward("꽝");

        GameResult gameResult = new GameResult();
        gameResult.add(name, reward);

        assertThat(gameResult.getResult().get(name)).isEqualTo(reward);
    }
}
