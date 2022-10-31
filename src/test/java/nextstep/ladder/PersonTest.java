package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    void 성공테스트() {
        Person person = new Person(new String[]{"person1","person2"});

        assertThat(person).isEqualTo(new Person(new String[]{"person1", "person2"}));
    }

    @Test
    void 중복오류_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Person(new String[]{"person1", "person1"})
        );
    }
}
