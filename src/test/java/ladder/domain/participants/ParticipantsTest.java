package ladder.domain.participants;

import ladder.domain.ladders.LadderGame;
import ladder.domain.ladder.LadderTest;
import ladder.domain.result.GameRecords;
import ladder.domain.result.GameRewardsTest;
import ladder.domain.ladders.reward.Reward;
import ladder.domain.result.RewardResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    public static final Participants participants = new Participants("pobi,honux,crong");
    public static final LadderGame LADDER_GAME = new LadderGame(LadderTest.ladder, GameRewardsTest.gameResult);
    @Test
    void start_ladder_game_and_get_result() {

        assertThat(participants.startGame(LADDER_GAME)).isEqualTo(
                new GameRecords(
                        List.of(
                                new RewardResult("pobi", "item2"),
                                new RewardResult("honux", "item1"),
                                new RewardResult("crong", "item0")
                        )
                )
        );
    }

    @Test
    void map_to() {
        Gamer pobi = new Gamer("pobi", 0);
        Gamer honux = new Gamer("honux", 1);
        Gamer crong = new Gamer("crong", 2);
        Participants participants = new Participants(List.of(
                pobi,
                honux,
                crong

        ));
        Reward item1 = new Reward("item1", 0);
    }
}