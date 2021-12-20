package nextstep.ladder;

import nextstep.ladder.domain.entity.Ladder;
import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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
                             .mapToObj(index -> createLine(createBooleans(input)))
                             .collect(collectingAndThen(toList(), Ladder::new));

    assertEquals(input, ladder.size());
  }

  @Test
  @DisplayName("빈 값을 넣을 경우 exception을 던진다.")
  void addEmptyLine() {
    assertThrows(IllegalArgumentException.class, () -> new Ladder(Collections.emptyList()));
  }

  @Test
  @DisplayName("사다리를 구성하는 각 줄의 사이즈가 다를 경우 exception을 던진다.")
  void addNotSameSizeLine() {
    Line line1 = createLine(Arrays.asList(true, false, false));
    Line line2 = createLine(Arrays.asList(false, false));
    Line line3 = createLine(Arrays.asList(true, false, true));


    assertThrows(IllegalArgumentException.class, () -> new Ladder(Arrays.asList(line1, line2, line3)));
  }

  @ParameterizedTest
  @CsvSource(value = {"0:3", "1:1", "2:0", "3:2"}, delimiter = ':')
  @DisplayName("사다리와 시작점을 주었을 때 마지막 도착 지점을 반환한다.")
  void exploreTest(int startingPoint, int result) {
    Line line1 = createLine(Arrays.asList(true, false, false));
    Line line2 = createLine(Arrays.asList(false, true, false));
    Line line3 = createLine(Arrays.asList(true, false, true));

    /*
    |-| | |
    | |-| |
    |-| |-|
     */
    Ladder ladder = new Ladder(Arrays.asList(line1, line2, line3));

    int explore = ladder.explore(startingPoint);
    assertEquals(result, explore);
  }

  private List<Boolean> createBooleans(int count) {
    return IntStream.range(0, count)
            .mapToObj(index -> true)
            .collect(toList());
  }

  private Line createLine(List<Boolean> booleanList) {
    List<Point> list = new ArrayList<>();
    list.add(createStart(booleanList.get(0)));


    creatBody(list, booleanList);

    list.add(createLast(list.get(list.size() - 1)));

    return new Line(list);
  }

  private Point createStart(boolean right) {
    return Point.first(right);
  }

  private void creatBody(List<Point> list, List<Boolean> booleanList) {
    IntStream.range(0, booleanList.size() - 1)
             .forEach(index -> {
               Point point = list.get(index);
               Point next = point.next(booleanList.get(index + 1));
               list.add(next);
             });

  }

  private Point createLast(Point point) {
    return point.last();
  }

}
