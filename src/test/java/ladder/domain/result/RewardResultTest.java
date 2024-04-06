package ladder.domain.result;

import ladder.domain.participants.Gamer;
import ladder.domain.participants.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardResultTest {

    @Test
    void is_same_name() {
        String targetName = "pobi";
        Gamer gamer = new Gamer(targetName, 0);
        Reward item = new Reward("item0", 0);

        assertThat(new RewardResult(item, gamer).isSameName(new Name(targetName))).isTrue();
    }
}