package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderMatcherTest {

  @Test
  @DisplayName("persons 와 results 를 받아서 matcher 객체를 생성한다.")
  void generate() {
    String[] personNames = new String[]{"bong", "dong", "jung"};
    Persons persons = Persons.generate(personNames);
    String[] resultNames = new String[]{"1", "2", "3"};
    Results results = Results.generate(resultNames);
    LadderMatcher.generate(persons, results, 5);
  }

  @Test
  @DisplayName("persons 와 results 수가 다르면 exception")
  void generate_fail_not_matched() {
    String[] personNames = new String[]{"bong", "dong", "jung"};
    Persons persons = Persons.generate(personNames);
    String[] resultNames = new String[]{"1", "2"};
    Results results = Results.generate(resultNames);

    assertThatIllegalArgumentException()
        .isThrownBy(() -> LadderMatcher.generate(persons, results, 5))
        .withMessage("not matched count.");
  }

  @ParameterizedTest
  @CsvSource(value = {"bong,2", "dong,1", "jung,3"})
  @DisplayName("사람이름 입력 시, 결과를 찾는다.")
  void findResultByPersonName(String name, String expected) {
    String[] personNames = new String[]{"bong", "dong", "jung"};
    Persons persons = Persons.generate(personNames);
    String[] resultNames = new String[]{"1", "2", "3"};
    Results results = Results.generate(resultNames);
    LadderMatcher ladderMatcher = LadderMatcher.generate(persons, results, 5, () -> true);
    String result = ladderMatcher.findResultByPersonName(name);
    assertEquals(result, expected);
  }
}