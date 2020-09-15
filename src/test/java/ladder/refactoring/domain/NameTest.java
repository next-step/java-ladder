package ladder.refactoring.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void creation_test() {
        Name name = Name.of("heesu");

        String input = "heesu";
        assertThat(name).isEqualTo(Name.of(input));
    }

    @Test
    void exception_test() {
        String input = "aasdfjaklsdjfklajsdklf";
        assertThatThrownBy(() -> Name.of(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
