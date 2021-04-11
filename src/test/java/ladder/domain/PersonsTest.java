package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonsTest {

    @Test
    void create() {
        // given
        String[] personNames = "pobi,honux,crong,jk".split(",");

        // when
        Persons persons = Persons.from(personNames);

        // then
        assertThat(persons).isEqualTo(Persons.from(personNames));
    }

    @Test
    @DisplayName("입력한 이름 수 만큼 사람이 생성된다")
    void create_size() {
        // given
        String[] personNames = "pobi,honux,crong,jk".split(",");

        // when
        int personSize = Persons.from(personNames).getPersons().size();

        // then
        assertThat(personSize).isEqualTo(personNames.length);
    }

    @Test
    @DisplayName("참여할 사람 이름 중복입력시 예외 발생한다.")
    void name_duplicate_exception() {
        String[] personNames = "pobi,honux,pobi,jk".split(",");
        assertThatThrownBy(() -> Persons.from(personNames))
                .isInstanceOf(RuntimeException.class);
    }
}
