package ladder.domain.first;

import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.domain.SequentialConnectionStrategy;
import ladder.engine.LadderCreator;
import ladder.factory.LadderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderPrizesTest {
    private Players players;
    private LadderPrizes ladderPrizes;
    private LadderCreator ladderCreator;

    @BeforeEach
    void setUp() {
        players = new Players("user1, user2, user3, user4");
        ladderPrizes = new LadderPrizes(Arrays.asList("a", "b", "c", "d"));
        ladderCreator = LadderFactory.create(5, 4, new SequentialConnectionStrategy());
    }

    @DisplayName("사다리 게임 결과 출력 확인")
    @Test
    void resultPrize() {
        Players result = ladderPrizes.result(players, ladderCreator);

        assertAll(
            () -> assertThat(result.getPlayers().get(new PlayerName("user1"))).isEqualTo("b"),
            () -> assertThat(result.getPlayers().get(new PlayerName("user2"))).isEqualTo("a"),
            () -> assertThat(result.getPlayers().get(new PlayerName("user3"))).isEqualTo("d"),
            () -> assertThat(result.getPlayers().get(new PlayerName("user4"))).isEqualTo("c")
        );
    }

}