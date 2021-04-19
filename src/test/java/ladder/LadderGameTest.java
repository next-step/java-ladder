package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderEdge;
import ladder.domain.Player;
import ladder.domain.Reward;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameTest {
    public final RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
        @Override
        public boolean randomBoolean() {
            return true;
        }
    };

    @Test
    public void ganeResultTest() {
        // given
        final int line = 6;
        final int height = 3;
        Ladder ladder = Ladder.valueOf(line, height, randomTrueBoolean);

        final List<Player> players = Arrays.asList(new Player("a"), new Player("b"), new Player("c"), new Player("d"), new Player("e"), new Player("f"));
        final List<Reward> rewards = Arrays.asList(new Reward("1등"), new Reward("2등"), new Reward("3등"), new Reward("4등"), new Reward("5등"), new Reward("6등"));
        LadderEdge ladderEdge = new LadderEdge(players, rewards);

        Map<String, String> expectResult = new HashMap<>();
        expectResult.put("a", "2등");
        expectResult.put("b", "1등");
        expectResult.put("c", "4등");
        expectResult.put("d", "3등");
        expectResult.put("e", "6등");
        expectResult.put("f", "5등");

        //when
        Map<String, String> result = ladderEdge.gameResult(ladder);

        // then
        Assertions.assertThat(result).isEqualTo(expectResult);
    }
}
