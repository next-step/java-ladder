package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTest {

  @Test
  @DisplayName("사람 수 및 높이로 사다리 생성")
  void generate() {
    Ladder ladder = Ladder.generate(5, 5, () -> true);
    ResultView.printLadder(ladder);
  }

  @ParameterizedTest
  @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
  @DisplayName("입력한 포지션의 결과를 찾는다.")
  void move(int start, int expected) {
    Ladder ladder = Ladder.generate(5, 5, () -> true);
    ResultView.printLadder(ladder);
    int result = ladder.move(start);
    assertEquals(result, expected);
  }
}
