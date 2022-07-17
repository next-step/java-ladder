package ladder.domain.first;

import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.domain.SequentialConnectionStrategy;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderPrizesTest {
    private static final int MAX_LADDER_HEIGHT = 5;
    private static final int COUNT_OF_LINES = 4;

    private Players players;
    private LadderPrizes ladderPrizes;
    private LadderCreator ladderCreator;

    @BeforeEach
    void setUp() {
        players = new Players("user1, user2, user3, user4");
        ladderPrizes = new LadderPrizes(Arrays.asList("a", "b", "c", "d"));
        List<LineCreator> lineCreators = new ArrayList<>();
        for (int i = 0; i < MAX_LADDER_HEIGHT; i++) {
            lineCreators.add(new HorizontalLines(COUNT_OF_LINES - 1));
        }
        ladderCreator = new Ladder(lineCreators, new SequentialConnectionStrategy());
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