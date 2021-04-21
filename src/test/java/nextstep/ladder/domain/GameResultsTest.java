package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.Map;
import nextstep.ladder.exception.PersonNotFoundException;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultsTest {

  @Test
  @DisplayName("GameResult가 생성된다.")
  void create() {
    assertThat(new GameResults()).isEqualTo(new GameResults());
  }

  @Test
  @DisplayName("GameResult는 빈 Map으로 생성된 것과 동일하다.")
  void createWithEmptyMap() {
    assertThat(new GameResults(new HashMap<>())).isEqualTo(new GameResults());
  }

  @Test
  @DisplayName("전체 결과를 반환한다.")
  void allResults() {
    // given
    final Map<Person, Result> results = Maps.newHashMap(Person.valueOf("pobi"), new Result("1000"));
    final GameResults gameResults = new GameResults(results);

    // when
    final Map<Person, Result> allResults = gameResults.allResults();

    // then
    assertThat(allResults).isEqualTo(results);
  }

  @Test
  @DisplayName("이름에 해당하는 결과를 반환한다.")
  void result() {
    // given
    final String pobiName = "pobi";
    final Result result = new Result("1000");
    final Map<Person, Result> results = Maps.newHashMap(Person.valueOf(pobiName), result);
    final GameResults gameResults = new GameResults(results);

    // when
    final Result gameResult = gameResults.resultOf(pobiName);

    // then
    assertThat(gameResult).isEqualTo(result);
  }

  @Test
  @DisplayName("존재하지 않는 사람을 조회하면 사람을 찾지 못했다는 예외가 발생한다.")
  void resultNonExistPerson() {
    // given
    final Map<Person, Result> results = Maps.newHashMap(Person.valueOf("pobi"), new Result("1000"));
    final GameResults gameResults = new GameResults(results);

    // when
    // then
    assertThatThrownBy(() -> gameResults.resultOf("hello"))
        .isInstanceOf(PersonNotFoundException.class)
        .hasMessage(PersonNotFoundException.PERSON_NOT_FOUND);
  }
}
