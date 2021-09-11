package ladder.domain;

import ladder.domain.ladder.LadderSize;
import ladder.domain.name.ParticipantName;
import ladder.domain.participant.Participant;
import ladder.domain.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @DisplayName("ParticipantName, Position 인스턴스를 받아 Pacitipant 인스턴스가 생성된다.")
    @Test
    void create() {
        assertThat(new Participant(new ParticipantName("ABCD"), new Position(0, new LadderSize(1)))).isNotNull();
    }
}
