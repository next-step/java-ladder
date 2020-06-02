package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.InvalidGameResultParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultsTests {
    @DisplayName("Players, Rewards 일급 컬렉션을 받아서 객체를 생성할 수 있음")
    @Test
    void createTest() {
        Players players = Players.create("sual, ita, poppo");
        Rewards rewards = Rewards.create("1, 2, 3");

        assertThat(GameResults.create(players, rewards)).isNotNull();
    }

    @DisplayName("Players, Rewards 일급 컬렉션의 크기가 다르면 예외 발생")
    @Test
    void createValidationTest() {
        Players players = Players.create("sual, ita, poppo");
        Rewards rewards = Rewards.create("1, 2");

        assertThatThrownBy(() -> GameResults.create(players, rewards))
                .isInstanceOf(InvalidGameResultParameterException.class);
    }
}
