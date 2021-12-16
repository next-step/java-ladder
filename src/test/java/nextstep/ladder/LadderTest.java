package nextstep.ladder;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

  @ParameterizedTest
  @ValueSource(ints = {5, 6, 7})
  @DisplayName("사다리를 생성한다.")
  void create(int input) {
    Ladder ladder = IntStream.range(0, input)
                             .mapToObj(index -> createLine(input))
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
                                                                .mapToObj(this::createLine)
                                                                .collect(collectingAndThen(toList(), Ladder::new)));
  }

  @ParameterizedTest
  @CsvSource(value = {"1:4", "2:2", "3:1", "4:3"}, delimiter = ':')
  @DisplayName("사다리와 시작점을 주었을 때 마지막 도착 지점을 반환한다.")
  void exploreTest(int startingPoint, int result) {
    Line line1 = createLine(Arrays.asList(false, true, false, false, false));
    Line line2 = createLine(Arrays.asList(false, false, true, false, false));
    Line line3 = createLine(Arrays.asList(false, true, false, true, false));

    /*
    |-| | |
    | |-| |
    |-| |-|
     */
    Ladder ladder = new Ladder(Arrays.asList(line1, line2, line3));

    int explore = ladder.explore(startingPoint);
    assertEquals(result, explore);
  }

  private Line createLine(int size) {
    return IntStream.range(0, size)
                    .mapToObj(index -> new Point())
                    .collect(collectingAndThen(toList(), Line::new));
  }

  private Line createLine(List<Boolean> booleanList) {
    return booleanList.stream()
                      .map(Point::new)
                      .collect(collectingAndThen(toList(), Line::new));
  }

}
