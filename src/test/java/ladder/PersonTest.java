package ladder;

import ladder.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    void create() {
        Person person = Person.of("pobi");
        assertThat(person).isEqualTo(Person.of("pobi"));
    }
}
