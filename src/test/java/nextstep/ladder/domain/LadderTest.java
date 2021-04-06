package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  @DisplayName("입력된 이름과, 높이로 이루어진 사다리를 생성한다.")
  void create() {
    //given
    int height = 4;
    String input = "bong,dong,jung";
    String[] names = input.split(",");
    //when
    Ladder ladder = Ladder.generate(names, height);
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
  @DisplayName("포지션 입력 시, 전체 사다리 타고 난 뒤 결과가 나온다.")
  void result() {
    Ladder ladder
        = Ladder.generate(new String[]{"bong", "dong", "jung"}, 5, () -> true);
    assertAll(
        () -> assertEquals(ladder.result("bong"), "dong"),
        () -> assertEquals(ladder.result("dong"), "bong"),
        () -> assertEquals(ladder.result("jung"), "jung")
    );
  }
}
