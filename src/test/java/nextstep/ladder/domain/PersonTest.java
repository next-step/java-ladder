package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  @DisplayName("5자 이하 이름을 가진 사람을 생성한다.")
  void create() {
    String name = "bongs";
    Person person = Person.create(name);
    assertAll(
        () -> assertThat(person).isNotNull(),
        () -> assertEquals(person.getName(), name)
    );
  }

  @Test
  @DisplayName("5자를 초과하는 이름으로 사람을 생성하려고 하면 Exception을 발생시킨다.")
  void create_fail() {
    String name = "bonggu";
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Person.create(name))
        .withMessage("name length > 5.");
  }
}