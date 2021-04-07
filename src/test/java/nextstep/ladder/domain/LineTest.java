package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  @DisplayName("사람의 수를 입력받아서 Line을 생성한다.")
  void create() {
    //given
    final int countOfPerson = 2;

    //when
    final Line line = new Line(countOfPerson);

    //then
    assertThat(line).isEqualTo(new Line(countOfPerson));
  }
}
