package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class MatchResultsTest {

  @DisplayName("사다리게임 전체결과 객체 생성 테스트.")
  @ParameterizedTest
  @CsvSource(value = {"user2,0,1","user1,0,0"})
  void crateMatchResultsTest(String name, int userIndex, int result) {
    List<Point> points = new ArrayList<>();
    points.add(new Point(0, new Location(false, false)));
    points.add(new Point(1, new Location(false, false)));

    List<Line> lines = new ArrayList<>();
    lines.add(new Line(points));
    Players players = new Players(Players.of("user1,user2"));

    MatchResults matchResult = MatchResults.createMatchResult(new Ladder(lines), players);

    List<MatchResult> findUser = matchResult.searchPrizeWithCondition(name);
    assertThat(findUser.get(userIndex).getIndex()).isEqualTo(result);
  }

  @DisplayName("사다리게임 전체결과 객체 생성 테스트.")
  @ParameterizedTest
  @ValueSource(strings = "user3")
  @NullSource
  @EmptySource
  void invalidData(String name) {
    List<Point> points = new ArrayList<>();
    points.add(new Point(0, new Location(false, false)));
    points.add(new Point(1, new Location(false, false)));

    List<Line> lines = new ArrayList<>();
    lines.add(new Line(points));
    Players players = new Players(Players.of("user1,user2"));

    MatchResults matchResult = MatchResults.createMatchResult(new Ladder(lines), players);

    assertThatThrownBy(() -> matchResult.searchPrizeWithCondition(name))
        .isInstanceOf(IllegalArgumentException.class);
  }
}