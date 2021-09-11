package nextstep.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.Ladders;
import nextstep.step2.domain.Participant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LaddersTest {


  @ParameterizedTest
  @ValueSource(strings = {"pobi,honux,crong,jk"})
  void Ladder_참가자_모집_테스트(String participantsStr) {
    String[] participants = participantsStr.split(",");

    GameParticipants gameParticipants = new GameParticipants(participantsStr);
    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      assertThat(gameParticipants.getGameParticipants(i)).isEqualTo(new Participant(participants[i]));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobi123,honux123,crong123,jk1234"})
  void Ladder_참가자명_길이_테스트(String participantsStr) {
    assertThatThrownBy(() -> new GameParticipants(participantsStr))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2})
  void Ladder_사다리_높이_입력_테스트(int ladderHeigh) {
    Ladders ladders = new Ladders(ladderHeigh);
    assertThat(ladders.getLadderHeigh()).isEqualTo(ladderHeigh);
  }
}
