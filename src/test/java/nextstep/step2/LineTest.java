package nextstep.step2;

import java.util.List;
import nextstep.step2.domain.GameParticipants;
import nextstep.step2.domain.Ladders;
import nextstep.step2.domain.Line;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {


  @ParameterizedTest
  @ValueSource(strings = {"pobi,honux,crong,jk"})
  void 사다리_line_생성_테스트(String participantsStr) {
    int ladderHeight = 5;
    GameParticipants gameParticipants = LadderGame.join(participantsStr);

    Ladders ladders = new Ladders(ladderHeight);
    List<Line> lines = ladders.create(gameParticipants);

    for (int i = 0; i < lines.size() - 1; i++) {
      System.out.print(lines.get(i).getPoint(i));
      System.out.print(" ");
    }
  }
}
