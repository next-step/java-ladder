package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTests {
    @DisplayName("Players, Rewards 일급 컬렉션을 받아서 객체를 생성할 수 있음")
    @Test
    void createTest() {
        Players players = Players.create("sual, ita, poppo");
        Rewards rewards = Rewards.create("1, 2, 3");

        assertThat(GameResults.create(players, rewards)).isNotNull();
    }
}
