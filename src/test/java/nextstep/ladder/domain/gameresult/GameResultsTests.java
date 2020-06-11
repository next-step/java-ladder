package nextstep.ladder.domain.gameresult;

import nextstep.ladder.domain.exceptions.InvalidGameResultParameterException;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultsTests {
    @DisplayName("Players, Rewards 일급 컬렉션을 받아서 객체를 생성할 수 있음")
    @Test
    void createTest() {
        Players players = Players.create(Arrays.asList("sual", "ita", "poppo"));
        Rewards rewards = Rewards.create("1, 2, 3");

        assertThat(GameResults.create(players, rewards)).isNotNull();
    }

    @DisplayName("Players, Rewards 일급 컬렉션의 크기가 다르면 예외 발생")
    @Test
    void createValidationTest() {
        Players players = Players.create(Arrays.asList("sual", "ita", "poppo"));
        Rewards rewards = Rewards.create("1, 2");

        assertThatThrownBy(() -> GameResults.create(players, rewards))
                .isInstanceOf(InvalidGameResultParameterException.class);
    }

    @DisplayName("Player 이름으로 결과를 찾을 수 있음")
    @Test
    void findByPlayerNameTest() {
        Players players = Players.create(Arrays.asList("sual", "ita", "poppo"));
        Rewards rewards = Rewards.create("1, 2, 3");

        GameResults gameResults = GameResults.create(players, rewards);

        assertThat(gameResults.findByPlayerName("ita").getName()).isEqualTo("2");
    }
}
