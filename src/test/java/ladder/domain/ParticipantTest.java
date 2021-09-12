package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderSize;
import ladder.domain.name.ParticipantName;
import ladder.domain.participant.Participant;
import ladder.domain.position.Position;
import ladder.helper.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @DisplayName("ParticipantName, Position 인스턴스를 받아 Participant 인스턴스가 생성된다.")
    @Test
    void create() {
        assertThat(new Participant(new ParticipantName("ABCD"), new Position(0, new LadderSize(1)))).isNotNull();
    }

    @DisplayName("참가자가 입력된 LadderFloor를 모두 지나면서 최종 위치가 결정된다.")
    @Test
    void moveToDestination() {
        Ladder ladder = Fixture.ladder();
        Participant participant = Fixture.participant();
        participant.moveToDestination(ladder.getFloors());

        assertThat(participant.hasEqualPosition(new Position(4, Fixture.ladderSize())));
    }
}
