package ladder.domain.result;

import ladder.domain.ladders.reward.Prize;
import ladder.domain.ladders.reward.Reward;
import ladder.domain.participants.Gamer;
import ladder.domain.participants.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardResultTest {

    public static final RewardResult result1 = new RewardResult(new Name("pobi"), new Prize("item0"));
    public static final RewardResult result2 = new RewardResult(new Name("honux"), new Prize("item1"));
    public static final RewardResult result3 = new RewardResult(new Name("honux"), new Prize("item2"));

    @Test
    void is_same_name() {
        String targetName = "pobi";
        Gamer gamer = new Gamer(targetName, 0);
        Reward item = new Reward("item0", 0);

        assertThat(result1.isSameName(new Name(targetName))).isTrue();
    }
}