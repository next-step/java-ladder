package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

  final int height = 3;
  final LadderHeight ladderHeight = new LadderHeight(height);
  final People people = People.from(new String[]{"pobi", "crong", "honux", "jk"});

  LineCreationStrategy lineCreationStrategy = () -> true;

  Ladder ladder;

  @BeforeEach
  void setUp() {
    ladder = new Ladder(people, ladderHeight, lineCreationStrategy);
  }

  @Test
  @DisplayName("높이와, 이름 목록을 받아서 생성한다.")
  void create() {
    assertThat(ladder).isEqualTo(new Ladder(people, ladderHeight, lineCreationStrategy));
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

  @ParameterizedTest
  @CsvSource({"pobi,1", "crong,0", "honux,3", "jk,2"})
  @DisplayName("사람을 입력받고, 해당하는 결과 인덱스를 반환한다.")
  void findResultIndex(final String name, final int result) {
    // given
    final Person person = Person.valueOf(name);

    // when
    final int resultIndex = ladder.findResultIndex(person);

    // then
    assertThat(resultIndex).isEqualTo(result);
  }

  @Test
  @DisplayName("결과 목록을 입력받고, 사다리를 탄 후의 결과 목록을 반환한다.")
  void findAllResults() {
    // given
    final List<Result> results = Lists.list(new Result("100"), new Result("200"), new Result("꽝"), new Result("5000"));
    final List<Result> expected = Lists.list(new Result("200"), new Result("100"), new Result("5000"), new Result("꽝"));

    // when
    final List<Result> allResults = ladder.findAllResults(results);

    // then
    assertThat(allResults).isEqualTo(expected);
  }
}
