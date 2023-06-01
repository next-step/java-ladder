package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ParticipantNamesTest {

    @Test
    @DisplayName("[요구사항 1] 참가자 수가 1명 미만일 경우 throw IllegalArgumentException")
    void 요구사항_1() {
        // given
        List<String> participantInput = List.of();

        // then
        assertThatThrownBy(() -> new ParticipantNames(participantInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 최소 1명 이상이어야 합니다.");
    }

    @Test
    @DisplayName("[요구사항 2] 참가자들의 수가 1명 이상일 경우 정상적으로 ParticipantNames가 생성된다.")
    void 요구사항_2() {
        // given
        List<String> participantInput = List.of("Ari", "Bri", "Cri");

        // when
        ParticipantNames participantNames = new ParticipantNames(participantInput);

        // then
        assertThat(participantNames.getParticipantsSize()).isEqualTo(3);
    }
}
