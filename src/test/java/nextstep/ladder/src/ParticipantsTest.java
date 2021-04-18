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
  public void assureNotEmpty(String str) {
    assertThatThrownBy(() -> {
      Participants.makeByString(str);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"민호,철수:2", "민호,철수 , 수지,영수:4"}, delimiter = ':')
  @DisplayName("check number of participants")
  public void assureNotEmpty(String str, int num) {
    Participants participants = Participants.makeByString(str);

    assertThat(participants.numberOfParticipants()).isEqualTo(num);
  }
}
