package ladder.domain.participants;

import ladder.domain.ladder.LadderGameTest;
import ladder.domain.ladders.reward.Prize;
import ladder.domain.ladders.reward.Reward;
import ladder.domain.result.RewardResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GamerTest {

    @Test
    void climb_a_ladder() {
        String name = "user";
        int initPosition = 0;
        int lastPosition = 2;
        Gamer gamer = new Gamer(name, initPosition);
        RewardResult climb = gamer.climb(LadderGameTest.LADDER_GAME);
        assertThat(gamer.climb(LadderGameTest.LADDER_GAME))
                .isEqualTo(new RewardResult(new Name(name), new Prize("item2")));
    }

    @Test
    void check_has_same_name() {
        String name = "user";
        int initPosition = 0;
        Gamer gamer = new Gamer(name, initPosition);
        assertThat(gamer.hasSameName(new Name(name))).isTrue();
    }

    @Test
    void check_has_same_position() {
        String name = "user";
        int initPosition = 0;
        Gamer gamer = new Gamer(name, initPosition);
        Reward item = new Reward("item", initPosition);
        assertThat(gamer.hasSamePosition(item)).isTrue();
    }
}