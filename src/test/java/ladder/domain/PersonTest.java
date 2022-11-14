package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {

    @Test
    void invalid() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Person("shineyuno"));
    }

    @Test
    void invalid_emptyName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Person(null));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Person(""));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Person(" "));
    }

    @Test
    void create() {
        Person person = new Person("pobi");
        assertThat(person.getName()).isEqualTo("pobi");
    }
}
