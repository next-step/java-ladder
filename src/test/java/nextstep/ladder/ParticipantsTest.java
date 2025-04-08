package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
  @Test
  @DisplayName("참가자 이름은 최대 5글자까지 부여할 수 있다.")
  void name_length_limit() {
    Participants participants = Participants.of(List.of("abcdefghij"));
    assertThat(participants.getNames()).containsExactly("abcde");
  }
}
