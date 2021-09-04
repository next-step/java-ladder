package nextstep.step2;

import static org.assertj.core.api.Assertions.assertThat;

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
}
