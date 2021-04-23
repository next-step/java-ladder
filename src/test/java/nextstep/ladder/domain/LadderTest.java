package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  final int height = 3;
  final LadderHeight ladderHeight = new LadderHeight(height);
  final People people = People.from(new String[]{"pobi", "crong", "honux", "jk"});

  LineCreationStrategy lineCreationStrategy = () -> true;

  Ladder ladder;

  @BeforeEach
  void setUp() {
    ladder = new Ladder(ladderHeight, lineCreationStrategy, people.personCount());
  }

  @Test
  @DisplayName("높이와 사람 수를 받아서 생성한다.")
  void create() {
    assertThat(ladder).isEqualTo(new Ladder(ladderHeight, lineCreationStrategy, people.personCount()));
  }

  @Test
  @DisplayName("Line 목록을 반환한다.")
  void lines() {
    // given
    final Line expectedLine = new Line(lineCreationStrategy, people.personCount());

    // when
    final List<Line> lines = ladder.lines();

    // then
    assertAll(
        () -> assertThat(lines).hasSize(height),
        () -> assertThat(lines.get(0)).isEqualTo(expectedLine),
        () -> assertThat(lines.get(1)).isEqualTo(expectedLine),
        () -> assertThat(lines.get(2)).isEqualTo(expectedLine)
    );
  }

  @Test
  @DisplayName("사람목록과 결과목록을 받아서 게임 결과를 반환한다.")
  void gameResults() {
    // given
    final String pobiName = "pobi";
    final String crongName = "crong";
    final String honuxName = "honux";
    final String jkName = "jk";
    final People people = People.from(new String[]{pobiName, crongName, honuxName, jkName});

    final List<Result> results = Lists.list(new Result("100"), new Result("200"), new Result("꽝"), new Result("5000"));

    final Map<Person, Result> allResults = new HashMap<>();
    allResults.put(Person.valueOf(pobiName), new Result("200"));
    allResults.put(Person.valueOf(crongName), new Result("100"));
    allResults.put(Person.valueOf(honuxName), new Result("5000"));
    allResults.put(Person.valueOf(jkName), new Result("꽝"));

    // when
    final GameResults gameResults = ladder.gameResults(people, results);

    // then
    assertThat(gameResults.allResults()).isEqualTo(allResults);
  }
}
