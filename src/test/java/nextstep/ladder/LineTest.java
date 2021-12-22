package nextstep.ladder;

import nextstep.ladder.domain.entity.Line;
import nextstep.ladder.domain.entity.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {

  @ParameterizedTest
  @ValueSource(ints = {5, 11, 6})
  @DisplayName("사다리를 생성하기 위해 사람의 숫자만큼 사다리를 생성한다.")
  void create(int countOfPerson) {
    Line line = createLine(createBooleans(countOfPerson));

    assertEquals(countOfPerson, line.size());
  }

  @ParameterizedTest
  @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
  @DisplayName("길과 시작점이 주어졌을 때 도착 지점을 반환한다.")
  void moveTest(int startingPoint, int result) {
    // way : |-| |-|
    Line line = createLine(Arrays.asList(true, false, true));

    int endPoint = line.move(startingPoint);
    assertEquals(result, endPoint);
  }

  private List<Boolean> createBooleans(int count) {
    return IntStream.range(0, count - 1)
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