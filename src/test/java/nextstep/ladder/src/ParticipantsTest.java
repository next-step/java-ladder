package nextstep.ladder.src;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}
