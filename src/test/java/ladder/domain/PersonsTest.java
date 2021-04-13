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
    @DisplayName("사람들 이름을 입력하면 Persons 객체를 생성한다")
    void create_size() {
        // given
        String[] personNames = "pobi,honux,crong,jk".split(",");

        // when
        int personSize = Persons.from(personNames).getPersons().size();

        // then
        assertThat(personSize).isEqualTo(personNames.length);
    }

    @Test
    @DisplayName("참여 사람 이름 중복 입력하면 예외 발생한다")
    void name_duplicate_exception() {
        String[] personNames = "pobi,honux,pobi,jk".split(",");
        assertThatThrownBy(() -> Persons.from(personNames))
                .isInstanceOf(RuntimeException.class);
    }
}
