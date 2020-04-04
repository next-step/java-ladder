package nextstep.ladder;

import nextstep.ladder.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {
    @Test
    @DisplayName("이름을 입력했을 떄, 5자가 넘으면 Exception을 발생한다.")
    void assertPersonNameLength() {
        String name = "yeoseon";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Person(name);
        }).withMessage(Person.PERSON_NAME_LENGTH_ERROR);
    }
}
