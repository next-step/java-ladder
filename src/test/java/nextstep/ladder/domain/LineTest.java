package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  LineCreationStrategy lineCreationStrategy;

  @BeforeEach
  void setUp() {
    lineCreationStrategy = () -> Stream.of(new Point(true), new Point(false))
        .collect(Collectors.toList());
  }

  @Test
  @DisplayName("사람의 수를 입력받아서 Line을 생성한다.")
  void create() {
    assertThat(new Line(lineCreationStrategy)).isEqualTo(new Line(lineCreationStrategy));
  }
}
