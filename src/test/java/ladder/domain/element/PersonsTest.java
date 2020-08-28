package ladder.domain.element;

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

    @Test
    @DisplayName("Persons exists 확인")
    void testPersonExists() {
        // given
        String[] names = { "pobi","honux","crong","jk" };
        // when
        Persons persons = Persons.fromText(String.join(",", names));
        // then
        assertThat(persons.exists("pobi")).isTrue();
    }

    @Test
    @DisplayName("이름으로 person 객체 정상적으로 가져오는지 확인")
    void testPersonByName() {
        // given
        String[] names = { "pobi","honux","crong","jk" };
        // when
        Persons persons = Persons.fromText(String.join(",", names));
        // then
        for (String name : names) {
            assertThat(persons.get(name).getName()).isEqualTo(name);
        }
    }

    @Test
    @DisplayName("정상 수행 후 person 확인")
    void testGetPersonByIndex() {
        // given
        String[] names = { "pobi","honux","crong","jk" };
        // when
        Persons persons = Persons.fromText(String.join(",", names));
        // then
        for (int i = 0; i < names.length; i++) {
            Person person = persons.get(i);
            assertThat(person.getName()).isEqualTo(names[i]);
        }
    }
}
