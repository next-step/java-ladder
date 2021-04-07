package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  @DisplayName("사람의 수를 입력받아서 Line을 생성한다.")
  void create() {
    //given
    final int countOfPerson = 2;
    final LineCreationStrategy lineCreationStrategy =
        () -> Stream.of(new Point(true), new Point(false))
            .collect(Collectors.toList());

    //when
    final Line line = new Line(countOfPerson, lineCreationStrategy);

    //then
    assertThat(line).isEqualTo(new Line(countOfPerson, lineCreationStrategy));
  }
}
