package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  public static final String DELIMITER = ",";

  @Test
  @DisplayName("입력된 이름과, 높이로 이루어진 사다리를 생성한다.")
  void create() {
    //given
    int height = 4;
    String input = "bong,dong,jung";
    String[] names = input.split(DELIMITER);
    String resultString = "1등,2등,3등";
    String[] results = resultString.split(DELIMITER);
    //when
    Ladder ladder = Ladder.generate(names, height, results);
    //then
    List<Person> persons = ladder.getPersons();
    List<Line> lines = ladder.getLines();
    assertAll(
        () -> assertEquals(persons.get(0).getName(), "bong"),
        () -> assertEquals(persons.get(1).getName(), "dong"),
        () -> assertEquals(persons.get(2).getName(), "jung"),
        () -> assertEquals(lines.size(), height)
    );
  }

  @Test
  @DisplayName("Person, Result 숫자가 맞지 않으면 exception")
  void generate_fail_not_equals_size() {
    //given
    int height = 4;
    String input = "bong,dong,jung";
    String[] names = input.split(DELIMITER);
    String resultString = "1등,2등,3등,4등";
    String[] results = resultString.split(DELIMITER);
    //when
    //then
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Ladder.generate(names, height, results))
        .withMessage("person.size != result.size");
  }

  @Test
  @DisplayName("포지션 입력 시, 전체 사다리 타고 난 뒤 결과가 나온다.")
  void result() {
    Ladder ladder
        = Ladder.generate(new String[]{"bong", "dong", "jung"}, 5, new String[]{"1","2","3"}, () -> true);
    assertAll(
        () -> assertEquals(ladder.result("bong"), Result.generate("2")),
        () -> assertEquals(ladder.result("dong"), Result.generate("1")),
        () -> assertEquals(ladder.result("jung"), Result.generate("3"))
    );
  }

  @Test
  @DisplayName("사다리에 없는 이름 입력 시, exception")
  void result_fail_not_matched() {
    Ladder ladder
        = Ladder.generate(new String[]{"bong", "dong", "jung"}, 5, new String[]{"1","2","3"});
    assertThatIllegalArgumentException()
        .isThrownBy(() -> ladder.result("ram"));
  }
}
