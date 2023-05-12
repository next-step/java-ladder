package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
  @Test
  void 참가자_생성_테스트() {
    List<Name> names = Arrays.asList(new Name("Alice"), new Name("Bob"), new Name("Carol"));
    Participants participants = new Participants(names);

    List<Participant> expectedParticipants = names.stream()
        .map(Participant::new)
        .collect(Collectors.toList());

    assertThat(participants.getParticipants()).isEqualTo(expectedParticipants);
  }

}