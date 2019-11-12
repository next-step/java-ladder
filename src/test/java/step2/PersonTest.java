package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {
    @Test
    void 이름_5글자() {
        Person person = new Person("abcd");

        assertThat(person.getLength()).isEqualTo(4);
    }

    @Test
    void 이름_5글자_초과에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new Person("abcdef");
        });
    }
}
