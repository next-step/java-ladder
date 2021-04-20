package nextstep.ladder.src.domain;

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

  @ParameterizedTest
  @CsvSource(value = {"tim,first,ted:5"}, delimiter = ':')
  @DisplayName("participants names max length")
  public void calcNamesMaxLength(String users, int max) {
    int calcMax = Participants.makeByString(users).maxNameLength();
    
    assertThat(calcMax).isEqualTo(max);
  }
}
