package ladder.domain.result;

import ladder.domain.participants.Gamer;
import ladder.domain.participants.Participants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void record_game_result() {
        Reward item0 = new Reward("item0", 0);
        Reward item1 = new Reward("item1", 1);
        Reward item2 = new Reward("item2", 2);
        GameResult gameResult = new GameResult(List.of(item0, item1, item2));

        Gamer pobi = new Gamer("pobi", 0);
        Gamer honux = new Gamer("honux", 1);
        Gamer crong = new Gamer("crong", 2);
        Participants participants = new Participants(List.of(pobi, honux, crong));

        assertThat(gameResult.recordResult(participants))
                .isEqualTo(new Records(
                        List.of(
                                new RewardResult(item0, pobi),
                                new RewardResult(item1, honux),
                                new RewardResult(item2, crong)
                        )
                ));
    }
}