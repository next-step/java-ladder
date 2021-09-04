package nextstep.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {


  @ParameterizedTest
  @ValueSource(strings = {"pobi,honux,crong,jk"})
  public void Ladder_참가자_모집_테스트(String participantsStr) {
    String[] participants = participantsStr.split(",");

    Ladders ladders = LadderGame.join(participantsStr);
    for (int i = 0; i < ladders.getParticipantsSize(); i++) {
      assertThat(ladders.getParticipant(i)).isEqualTo(new Participant(participants[i]));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobi123,honux123,crong123,jk1234"})
  public void Ladder_참가자명_길이_테스트(String participantsStr) {

    assertThatThrownBy(() -> LadderGame.join(participantsStr))
        .isInstanceOf(IllegalArgumentException.class);
  }

}
