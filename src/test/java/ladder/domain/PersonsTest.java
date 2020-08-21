package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonsTest {

    @Test
    @DisplayName("text blank 설정")
    void testPersonFromTextBlank() {
        assertThatThrownBy(() -> Persons.fromText("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Persons.fromText(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Persons.fromText(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Persons 정상 생성")
    void testCreatePersons() {
        // given
        String[] names = { "pobi","honux","crong","jk" };
        // when
        Persons persons = Persons.fromText(String.join(",", names));
        // then
        for (Person person : persons) {
            assertThat(names).contains(person.getName());
        }
    }

    @Test
    @DisplayName("Persons 사이즈")
    void testPersonsSize() {
        // given
        String[] names = { "pobi","honux","crong","jk" };
        // when
        Persons persons = Persons.fromText(String.join(",", names));
        // then
        assertThat(persons.size()).isEqualTo(names.length);
    }
}
