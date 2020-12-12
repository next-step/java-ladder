package ladder.step3_renewal.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3_renewal.domain.Participants;
import step3_renewal.domain.Reward;
import step3_renewal.domain.Rewards;
import step3_renewal.utils.StringUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {

    Participants participants;
    List<String> participantList = Arrays.asList("yura", "hih", "ttii", "tm");

    @BeforeEach
    public void setup() {
        participants = Participants.of(participantList);
    }

    @ParameterizedTest
    @DisplayName("입력받은 리워드 정상 입력 후 리스트에 담겼는지 확인")
    @ValueSource(strings = {"1000,꽝,1등,2등"})
    public void 입력받은_리워드_정상노출_확인(String rewardName) {
        Rewards reward = Rewards.of(StringUtil.splitNames(rewardName), participantList.size());
        assertThat(reward.getRewards().size()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("입력받은 리워드 빈값인 경우 예외")
    @EmptySource
    public void 입력받은_리워드_빈값인경(String rewardName) {
        assertThatThrownBy(() -> Reward.of(rewardName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("제공 될 보상을 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("입력받은 리워드수 참여자수 불일치 예외")
    @ValueSource(ints = {1, 3, 8})
    public void 리워드수_참여자수_불일치(int sizeOfParticipants) {
        String rewardName = "1000,20000,3000,4000";
        assertThatThrownBy(() ->
                Rewards.of(StringUtil.splitNames(rewardName), sizeOfParticipants)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자와 리워드 보상수가 일치하지 않습니다. (참여자 수: %d, 리워드 수: %d)", sizeOfParticipants, 4);
    }
}
