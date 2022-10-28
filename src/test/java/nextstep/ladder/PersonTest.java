package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    void person() {
        Person person = new Person(new String[]{"person1","person2"});

        assertThat(person).isEqualTo(new Person(new String[]{"person1", "person2"}));
    }
}
