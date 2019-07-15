package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private Result result;

    @BeforeEach
    void setUp() {
        final Participants participants = new Participants(Arrays.asList("1", "2", "3"));
        final Rewards rewards = new Rewards(Arrays.asList("1", "2", "3"));
        final List<Integer> arrivalIndex = Arrays.asList(0, 2, 1);

        result = new Result(participants, rewards, arrivalIndex);
    }

    @Test
    @DisplayName("Result는 참여자와 당첨상품 그리고 사다리 결과로 생성한다.")
    void new_WithParticipantsRewardsArrivalIndex_created() {
        assertThat(result).isInstanceOf(Result.class);
    }

    @Test
    @DisplayName("Result에서 참여자의 이름으로 Participant객체를 가져올 수 있다.")
    void getParticipant_WithName_returnedParticipant() {
        assertThat(result.getParticipant("1")).isInstanceOf(Participant.class);
    }

    @Test
    @DisplayName("Result에서 참여하지 않은 사람을 가져오려 할 경우 예외가 발생된다.")
    void getParticipant_WithNotInName_exceptionThrown() {
        assertThatThrownBy(() -> result.getParticipant("0"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Result에서 당첨 결과를 확인할 수 있다.")
    void getReward_WithParticipant_returnedReward() {
        final Participant participant = result.getParticipant("1");
        assertThat(result.getReward(participant)).isEqualTo(new Reward("1"));
    }

    @Test
    @DisplayName("Result에서 참여하지 않은 사람의 당첨 결과를 조회할 경우 예외가 발생한다.")
    void getReward_WithNotInParticipant_exceptionThrown() {
        final Participant participant = new Participant("0");
        assertThatThrownBy(() -> result.getReward(participant))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
