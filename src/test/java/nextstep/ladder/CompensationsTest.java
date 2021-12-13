package nextstep.ladder;

import nextstep.ladder.domain.Compensations;
import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CompensationsTest {
    @Test
    @DisplayName("checkCompensationsSize 메소드느 참가자와 보상 크기가 다르면 보상과 참가자 수가 다릅니다. 를 반환")
    void compensationsTest() {
        Participants participants = Participants.of("A,B,C");
        assertThatThrownBy(() -> {
            Compensations compensations = Compensations.of("꽝,우승", participants.getParticipantsSize());
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보상과 참가자 수가 다릅니다.");
    }
}
