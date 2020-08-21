package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    @DisplayName("사람 이름 blank 설정")
    void testSetNameBlank() {
        assertThatThrownBy(() -> new Person("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Person(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Person(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사람 이름 기준 길이 이상 설정")
    void testSetNameOverLength() {
        assertThatThrownBy(() -> new Person("mondss")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사람 정상 생성")
    void testCreatePerson() {
        final String name = "monds";
        Person person = new Person(name);
        assertThat(person.getName()).isEqualTo(name);
    }
}
