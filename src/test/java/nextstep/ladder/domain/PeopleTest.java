package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {

  @Test
  @DisplayName("Person 목록을 받아서 People을 생성한다.")
  void create() {
    //given
    final List<Person> peopleSource = Lists.list(
        new Person("pobi"),
        new Person("crong"),
        new Person("honux"),
        new Person("jk")
    );

    //when
    final People people = new People(peopleSource);

    //then
    assertThat(people).isEqualTo(new People(peopleSource));
  }

  @Test
  @DisplayName("이름 배열을 받아서 People을 생성한다.")
  void createWithStringArray() {
    //given
    final String[] names = new String[]{"pobi", "crong", "honux", "jk"};

    //when
    final People people = new People(names);

    //then
    assertThat(people).isEqualTo(new People(names));
  }
}
