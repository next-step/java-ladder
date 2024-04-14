package ladder.domain.result;

import ladder.domain.ladders.reward.GameRewards;
import ladder.domain.ladders.reward.Reward;
import ladder.domain.participants.Gamer;
import ladder.domain.participants.Participants;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameRewardsTest {

    public static final GameRewards gameResult = new GameRewards(
            List.of(
                    new Reward("item0", 0),
                    new Reward("item1", 1),
                    new Reward("item2", 2)
            )
    );

    @Test
    void record_game_result() {
        Reward item0 = new Reward("item0", 0);
        Reward item1 = new Reward("item1", 1);
        Reward item2 = new Reward("item2", 2);
        GameRewards gameResult = new GameRewards(List.of(item0, item1, item2));

        Gamer pobi = new Gamer("pobi", 0);
        Gamer honux = new Gamer("honux", 1);
        Gamer crong = new Gamer("crong", 2);
        Participants participants = new Participants(List.of(pobi, honux, crong));

    }
}