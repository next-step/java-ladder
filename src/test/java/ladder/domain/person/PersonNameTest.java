package ladder.domain.person;

import ladder.exception.person.IllegalPersonNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PersonNameTest {

    @Test
    void create() {
        PersonName personName = new PersonName("pobi");

        assertThat(personName).isEqualTo(new PersonName("pobi"));
    }

    @DisplayName("사람 이름은 null이거나 공백일 수 없습니다.")
    @Test
    void valid_empty() {
        assertAll(
                () -> assertThatThrownBy(() -> new PersonName(null)).isInstanceOf(IllegalPersonNameException.class),
                () -> assertThatThrownBy(() -> new PersonName("")).isInstanceOf(IllegalPersonNameException.class),
                () -> assertThatThrownBy(() -> new PersonName("  ")).isInstanceOf(IllegalPersonNameException.class)
        );
    }

    @DisplayName("사람 이름은 5글자 이상이어야 합니다.")
    @Test
    void valid_length() {
        assertThatThrownBy(() -> new PersonName("abcdef")).isInstanceOf(IllegalPersonNameException.class);
    }
}
