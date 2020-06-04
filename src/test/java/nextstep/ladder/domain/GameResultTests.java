package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTests {
    @DisplayName("Player, Reward 객체를 입력받아서 객체 생성 가능")
    @Test
    void createTest() {
        Player player = new Player("poppo", new HorizontalLocation(0, 3));
        Reward reward = new Reward("1000");

        assertThat(new GameResult(player, reward)).isNotNull();
    }
}
