package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PersonsTest {

  @Test
  @DisplayName("이름 배열을 받아 Persons 객체를 생성한다.")
  void generate() {
    String[] names = {"bong", "dong", "jung"};
    Persons persons = Persons.generate(names);
    assertEquals(persons.size(), names.length);
  }

  @ParameterizedTest
  @CsvSource(value = {"bong,0", "dong,1", "jung,2"})
  @DisplayName("해당이름의 인덱스 번호를 찾는다.")
  void findIndex(String name, int expected) {
    String[] names = {"bong", "dong", "jung"};
    Persons persons = Persons.generate(names);
    int index = persons.findIndex(name);
    assertEquals(index, expected);
  }

  @Test
  @DisplayName("없는 이름 입력 시, exception")
  void findIndex_fail() {
    String[] names = {"bong", "dong", "jung"};
    Persons persons = Persons.generate(names);
    assertThatIllegalArgumentException()
        .isThrownBy(() -> persons.findIndex("name"))
        .withMessage("not matched person.");
  }


}