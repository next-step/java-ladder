package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderResultTest {

    @Test
    @DisplayName("참가자의 사다리 타기 결과 테스트")
    public void getOutcomeForParticipant() {
        LadderResult ladderResult = new LadderResult();
        Map<String, String> participantOutcomes = ladderResult.getParticipantOutcomes();

        participantOutcomes.put("aaaa", "꽝");
        participantOutcomes.put("bbbb", "5000");
        participantOutcomes.put("cccc", "꽝");
        participantOutcomes.put("dddd", "3000");

        assertThat(ladderResult.getOutcomeForParticipant("aaaa")).isEqualTo("꽝");
        assertThatThrownBy(() -> ladderResult.getOutcomeForParticipant("abab"))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("존재하지 않는 참가자입니다.");

    }

}
