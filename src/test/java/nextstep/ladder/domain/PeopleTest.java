package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PeopleTest {

  @Test
  @DisplayName("People 인스턴스를 생성한다")
  void createPeople() {
    People people = new People(List.of(new Person("pobi"), new Person("crong"), new Person("honux")));
    assertThat(people.getPeopleNumber()).isEqualTo(3);
  }

  @Test
  @DisplayName("참여자가 2명 미만일 경우 예외를 발생한다")
  void canNotCreateLessThanTwo() {
    assertThatThrownBy(() -> new People(List.of(new Person("pobi"))))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
