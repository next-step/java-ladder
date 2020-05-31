package ladder.step2.domain;

import ladder.step2.exception.ParticipantsMinimumSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {

  @DisplayName("참여자가 2명 미만일 경우에 ParticipantsMinimumSizeException 발생")
  @ParameterizedTest
  @ValueSource(strings = { "aa", "" })
  void 참여자수_검증_테스트 (String participants) {
    assertThatExceptionOfType(ParticipantsMinimumSizeException.class)
      .isThrownBy(() -> Participants.ofString(participants));
  }
}
