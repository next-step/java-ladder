package nextstep.ladder;

import nextstep.ladder.domain.entity.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {

  @ParameterizedTest
  @ValueSource(ints = {5, 11, 6})
  @DisplayName("사다리를 생성하기 위해 사람의 숫자만큼 사다리를 생성한다.")
  void create(int countOfPerson) {
    Line line = new Line(countOfPerson);
    assertEquals(countOfPerson, line.size());
  }

}