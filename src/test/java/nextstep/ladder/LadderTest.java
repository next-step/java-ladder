package nextstep.ladder;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

  private Random random;

  @BeforeEach
  void setUp() {
    random = new Random();
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 6, 7})
  @DisplayName("사다리를 생성한다.")
  void create(int input) {
    Ladder ladder = IntStream.range(0, input)
                             .mapToObj(idx -> new Line(input, random::nextBoolean))
                             .collect(collectingAndThen(toList(), Ladder::new));

    assertEquals(input, ladder.size());
  }

  @Test
  @DisplayName("빈 값을 넣을 경우 exception을 던진다.")
  void addEmptyLine() {
    assertThrows(IllegalArgumentException.class, () -> new Ladder(Collections.emptyList()));
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 6, 7})
  @DisplayName("사다리를 구성하는 각 줄의 사이즈가 다를 경우 exception을 던진다.")
  void addNotSameSizeLine(int input) {
    assertThrows(IllegalArgumentException.class, () -> IntStream.range(0, input)
                                                                .mapToObj(index -> new Line(index, random::nextBoolean))
                                                                .collect(collectingAndThen(toList(), Ladder::new)));
  }

}
