package ladder.domain;

import ladder.exception.PositionOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.Rewards.POSITION_OUT_OF_RANGE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {

    @Test
    @DisplayName("보상목록을 생성한다")
    void create() {
        Rewards rewards = new Rewards("꽝", "3000", "꽝", "3000");
        Rewards equalExpected = new Rewards("꽝", "3000", "꽝", "3000");
        Rewards notEqualExpected = new Rewards("3000", "5000", "꽝", "3000");

        assertThat(rewards).isEqualTo(equalExpected);
        assertThat(rewards).isNotEqualTo(notEqualExpected);
    }

    @Test
    @DisplayName("게임결과를 도출한다: 성공")
    void result_성공() {
        Rewards rewards = new Rewards("꽝", "3000", "꽝", "3000");
        Player player = new Player(new PlayerName("pobi"), new Position(1, 5));
        Result actual = rewards.result(player);
        Result expected = new Result(new PlayerName("pobi"), new RewardName("3000"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임결과들을 도출한다: 실패(범위를 초과)")
    void result_실패_범위초과() {
        assertThatThrownBy(() -> {
            Rewards rewards = new Rewards("꽝", "3000", "꽝", "3000");
            Player player = new Player(new PlayerName("pobi"), new Position(4, 5));
            rewards.result(player);
        }).isInstanceOf(PositionOutOfRangeException.class)
                .hasMessage(POSITION_OUT_OF_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("게임결과들을 도출한다: 성공")
    void results_성공() {
        Rewards rewards = new Rewards("꽝", "3000", "2000", "1000");
        Players players = new Players(List.of(
                new Player(new PlayerName("pobi"), new Position(0, 5)),
                new Player(new PlayerName("crong"), new Position(1, 5)),
                new Player(new PlayerName("honux"), new Position(2, 5)),
                new Player(new PlayerName("jk"), new Position(3, 5))
        ));

        Results actual = rewards.results(players);
        Results expected = new Results(List.of(
                new Result(new PlayerName("pobi"), new RewardName("꽝")),
                new Result(new PlayerName("crong"), new RewardName("3000")),
                new Result(new PlayerName("honux"), new RewardName("2000")),
                new Result(new PlayerName("jk"), new RewardName("1000"))
        ));

        assertThat(actual).isEqualTo(expected);
    }
}
