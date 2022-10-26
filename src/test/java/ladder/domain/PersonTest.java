package ladder.domain;

import ladder.domain.person.Person;
import ladder.exception.person.PersonNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @DisplayName("사람 이름은 최대 5글자이다.")
    @Test
    void valid_personname_length() {
        assertThatThrownBy(() -> new Person("abcdef")).isInstanceOf(PersonNameLengthException.class);
    }
}
