import domain.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {
    @Test
    void PersonTest() {
        assertThatThrownBy(() -> {
            new Person("test12");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자까지만 입력 가능합니다.");
    }
}
