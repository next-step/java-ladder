package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderLineTest {

  @Test
  @DisplayName("사람수 만큼 생성한다.")
  void generate() {
    int sizeOfPerson = 5;
    LadderLine ladderLine = LadderLine.generate(sizeOfPerson, () -> true);
    assertEquals(ladderLine.size(), 5);
  }

  @ParameterizedTest
  @CsvSource(value = {"0,1", "1,0", "2,2"})
  @DisplayName("이동한 결과를 찾는다.")
  void move(int position, int expected) {
    LadderLine line = LadderLine.generate(3, () -> true);
    int result = line.move(position);
    assertEquals(result, expected);
  }

}