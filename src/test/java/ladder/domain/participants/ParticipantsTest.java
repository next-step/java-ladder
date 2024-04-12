package ladder.domain.participants;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.result.Reward;
import ladder.domain.result.RewardResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    void start_ladder_game_and_get_result() {
        Participants participants = new Participants("pobi,honux,crong");
        Ladder ladder = new Ladder(
                List.of(
                        new Line(true, false),
                        new Line(false, true)
                )
        );

        assertThat(participants.startGame(ladder)).isEqualTo(
                new Participants(
                        List.of(
                                new Gamer("pobi", 2),
                                new Gamer("honux", 0),
                                new Gamer("crong", 1)
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
        assertThat(participants.mapTo(item1)).isEqualTo(new RewardResult(item1, pobi));
    }
}