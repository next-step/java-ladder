package ladder.domain.person;

import ladder.exception.person.PeopleSizeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PeopleTest {

    @Test
    void valid_size() {
        assertThatThrownBy(() -> new People("pobi")).isInstanceOf(PeopleSizeException.class);
    }

    @Test
    void find_persons() {
        People people = new People("pobi", "crong", "sik");

        Assertions.assertAll(
                () -> assertThat(people.findByName("crong"))
                        .contains(new Person("crong")),
                () -> assertThat(people.findByName("pobi","crong"))
                        .contains(new Person("crong"), new Person("crong")),
                () -> assertThat(people.findByName("all"))
                        .contains(new Person("pobi"), new Person("crong"), new Person("sik"))
        );
    }

    @DisplayName("같은 이름이 여러번 입력됐을 경우 하나만 반환한다.")
    @Test
    void find_persons_distinct() {
        People people = new People("pobi", "crong", "sik");

        Assertions.assertAll(
                () -> assertThat(people.findByName("pobi","pobi")).contains(new Person("pobi")),
                () -> assertThat(people.findByName("pobi","pobi").size()).isEqualTo(1)
        );
    }
}
