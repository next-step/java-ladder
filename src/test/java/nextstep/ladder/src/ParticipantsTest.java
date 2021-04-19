package nextstep.ladder.src;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ParticipantsTest {
  
  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("exception with empty or null")
  public void assureNotEmpty(String users) {
    assertThatThrownBy(() -> {
      Participants.makeByString(users);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"민호,철수:2", "민호,철수 , 수지,영수:4"}, delimiter = ':')
  @DisplayName("check number of participants")
  public void assureNotEmpty(String users, int numberOfParticipants) {
    Participants participants = Participants.makeByString(users);

    assertThat(participants.numberOfParticipants()).isEqualTo(numberOfParticipants);
  }
}
