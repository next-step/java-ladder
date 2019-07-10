package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.util.StringSplitter;

public class RewardsTest {
    @Test
    @DisplayName("Rewards는 Reward들을 갖고있는 일급 컬렉션이다.")
    void new_Participants_Created() {
        final List<String> rewardStrings = createRewardStrings();
        assertThat(new Rewards(rewardStrings)).isInstanceOf(Rewards.class);
    }

    @Test
    @DisplayName("Participants에서 얻은 Participant 리스트는 수정할 수 없다.")
    void getParticipants_Modify_ExceptionThrown() {
        final Rewards rewards = new Rewards(createRewardStrings());
        final List<Reward> rewardsList = rewards.getRewards();

        assertThatThrownBy(() -> rewardsList.add(new Reward("test")))
                .isExactlyInstanceOf(UnsupportedOperationException.class);
    }

    private static List<String> createRewardStrings() {
        final String input = "꽝, 5000, 꽝, 3000";
        return StringSplitter.split(input);
    }
}
