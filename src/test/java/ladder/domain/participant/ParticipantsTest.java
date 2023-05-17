package ladder.domain.participant;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
  @Test
  void 참가자_생성_테스트() {
    List<Name> names = List.of(new Name("Alice"), new Name("Bob"), new Name("Carol"));
    Participants participants = new Participants(names);

    assertThat(participants.getParticipants()).isEqualTo(names);
  }

}