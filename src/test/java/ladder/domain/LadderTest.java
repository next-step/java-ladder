package ladder.domain;

import ladder.strategy.LineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    private LineStrategy lineStrategyTrue = () -> true;

    @Test
    @DisplayName("주어진 height 만큼의 row를 생성한다.")
    void 사다리_생성() {
        Ladder ladder = new Ladder(3, 3);
        assertThat(ladder.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 players와 prizes에 대해 사다리를 타고 이동한 후 결과를 반환한다.")
    void 사다리_이동() {
        LadderRow ladderRow = new LadderRow(1, lineStrategyTrue);
        Ladder ladder = new Ladder(3, ladderRow);
        Players players = new Players(List.of("a","b"));
        Prizes prizes = new Prizes(List.of("1","2"));

        Result expected = new Result();
        expected.put(players.get(0), prizes.get(1));
        expected.put(players.get(1), prizes.get(0));

        assertThat(ladder.play(players,prizes)).isEqualTo(expected);
    }
}
