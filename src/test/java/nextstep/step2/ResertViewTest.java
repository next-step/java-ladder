package nextstep.step2;

import nextstep.step2.domain.GameParticipants;
import nextstep.step2.view.ResertView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResertViewTest {

  @ParameterizedTest
  @ValueSource(strings = {"pobi,honux,crong,jk"})
  void Ladder_참가자_출력_테스트(String participantsStr){
    GameParticipants gameParticipants = LadderGame.join(participantsStr);
    ResertView.print(gameParticipants);
  }
}
