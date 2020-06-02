package ladder.step3.domain;

import ladder.step3.exception.LadderResultSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderResultsTest {

  @DisplayName("참여자의 수와 결과의 수가 일치하지 않을 경우 LadderResultSizeException 발생")
  @ParameterizedTest
  @MethodSource("provideParticipantsAndResults")
  void 결과_수_검증_테스트 (String ladderResults, Participants participants) {
    assertThatExceptionOfType(LadderResultSizeException.class)
      .isThrownBy(() -> LadderResults.of(ladderResults, participants));
  }

  private static Stream<Arguments> provideParticipantsAndResults () {
    Participants participants = Participants.ofString("aa,bb,cc");
    return Stream.of(
      Arguments.of("1,2", participants),
      Arguments.of("1,2,3,4", participants)
    );
  }

  @DisplayName("Participatns에 Participant가 존재하는지 확인하는 테스트")
  @ParameterizedTest
  @MethodSource("provideParticipantsOfParticipant")
  void 참여자_확인_테스트 (Participants participants, Participant participant) {
    assertEquals(
      participant,
      participants.stream()
                  .filter(v -> v == participant)
                  .findAny()
                  .orElse(null));
  }

  private static Stream<Arguments> provideParticipantsOfParticipant () {
    Participants participants = Participants.ofString("aa,bb,cc");
    return Stream.of(
      Arguments.of(participants, Participant.valueOf("aa")),
      Arguments.of(participants, Participant.valueOf("bb")),
      Arguments.of(participants, Participant.valueOf("cc"))
    );
  }
}
