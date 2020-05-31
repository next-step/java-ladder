package ladder.step2.domain;

import ladder.step2.exception.ParticipantNameMaximumSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParticipantTest {

  @DisplayName("참여자의 이름이 5글자 이상일 경우 ParticipantNameMaximumSizeException 발생")
  @ParameterizedTest
  @ValueSource(strings = { "123456", "abcdef", "aaaaaa" })
  void 참여자_이름_검증 (String name) {
    assertThatExceptionOfType(ParticipantNameMaximumSizeException.class)
      .isThrownBy(() -> Participant.valueOf(name));
  }
}
