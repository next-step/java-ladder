package ladder.domain;

import ladder.exception.NoNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static ladder.domain.PlayerNameTest.*;
import static ladder.domain.Results.NO_NAME_MESSAGE;
import static ladder.domain.RewardNameTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {

    @Test
    void create() {
        Results actual = new Results(Map.of(
                PLAYER_NAME_POBI, REWARD_NAME_꽝,
                PLAYER_NAME_JK, REWARD_NAME_5000,
                PLAYER_NAME_CRONG, REWARD_NAME_꽝,
                PLAYER_NAME_HONUX, REWARD_NAME_3000
        ));
        Results expected = new Results(Map.of(
                PLAYER_NAME_JK, REWARD_NAME_5000,
                PLAYER_NAME_POBI, REWARD_NAME_꽝,
                PLAYER_NAME_CRONG, REWARD_NAME_꽝,
                PLAYER_NAME_HONUX, REWARD_NAME_3000
        ));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 이름에 해당하는 결과 출력")
    void reward() {
        Results results = new Results(Map.of(
                PLAYER_NAME_POBI, REWARD_NAME_꽝,
                PLAYER_NAME_JK, REWARD_NAME_5000,
                PLAYER_NAME_CRONG, REWARD_NAME_꽝,
                PLAYER_NAME_HONUX, REWARD_NAME_3000
        ));
        RewardName actual = results.result(new PlayerName("pobi"));
        RewardName expected = new RewardName("꽝");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 이름이 없으면 오류")
    void reward_플레이어_이름_없으면_오류() {
        assertThatThrownBy(() -> {
            Results results = new Results(Map.of(
                    PLAYER_NAME_POBI, REWARD_NAME_꽝,
                    PLAYER_NAME_JK, REWARD_NAME_5000,
                    PLAYER_NAME_CRONG, REWARD_NAME_꽝,
                    PLAYER_NAME_HONUX, REWARD_NAME_3000
            ));
            results.result(new PlayerName("pppp"));
        }).isInstanceOf(NoNameException.class)
                .hasMessage(NO_NAME_MESSAGE);
    }

    @Test
    @DisplayName("결과 모두 출력")
    void rewards() {
        Results results = new Results(Map.of(
                PLAYER_NAME_POBI, REWARD_NAME_꽝,
                PLAYER_NAME_JK, REWARD_NAME_5000,
                PLAYER_NAME_CRONG, REWARD_NAME_꽝,
                PLAYER_NAME_HONUX, REWARD_NAME_3000
        ));
        Map<PlayerName, RewardName> actual = results.results();
        Map<PlayerName, RewardName> expected = Map.of(
                PLAYER_NAME_POBI, REWARD_NAME_꽝,
                PLAYER_NAME_JK, REWARD_NAME_5000,
                PLAYER_NAME_CRONG, REWARD_NAME_꽝,
                PLAYER_NAME_HONUX, REWARD_NAME_3000
        );

        assertThat(actual).isEqualTo(expected);
    }
}
