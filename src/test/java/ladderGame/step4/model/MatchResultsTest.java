package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class MatchResultsTest {

  @DisplayName("사다리객체와 사용자 객체를 주입했을 때 검색하는 사용자 명에 대한 사다리 결과값 인덱스를 반환해야 한다.")
  @ParameterizedTest
  @CsvSource(value = {"user2,0,1", "user1,0,0", "all,0,0", "all,1,1"})
  void crateMatchResultsTest(String name, int userIndex, int result)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    List<Point> points = new ArrayList<>();
    points.add(new Point(0, Location.first(false)));
    points.add(new Point(1, Location.first(false)));

    List<Line> lines = new ArrayList<>();
    lines.add(new Line(points));
    Players players = Players.from("user1,user2");

    Constructor<Ladder> constructor = Ladder.class.getDeclaredConstructor(List.class);
    constructor.setAccessible(true);

    Ladder ladder = constructor.newInstance(lines);

    MatchResults matchResult = MatchResults.createMatchResult(ladder, players);
    List<MatchResult> findUser = matchResult.searchPrizeWithCondition(name);

    assertThat(findUser.get(userIndex).getIndex()).isEqualTo(result);
  }

  @DisplayName("사다리객체와 사용자 객체를 주입했을 때 검색대상자가 없을때 에러를 반환한다.")
  @ParameterizedTest
  @ValueSource(strings = "user3")
  @NullSource
  @EmptySource
  void invalidData(String name)
      throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    List<Point> points = new ArrayList<>();
    points.add(new Point(0, Location.first(false)));
    points.add(new Point(1, Location.first(false)));

    List<Line> lines = new ArrayList<>();
    lines.add(new Line(points));
    Players players = Players.from("user1,user2");

    Constructor<Ladder> constructor = Ladder.class.getDeclaredConstructor(List.class);
    constructor.setAccessible(true);

    Ladder ladder = constructor.newInstance(lines);

    MatchResults matchResult = MatchResults.createMatchResult(ladder, players);

    assertThatThrownBy(() -> matchResult.searchPrizeWithCondition(name))
        .isInstanceOf(IllegalArgumentException.class);
  }
}