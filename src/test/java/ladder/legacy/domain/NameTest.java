package ladder.legacy.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void Name_creation_test() {
        String input = "abcdefg";

        assertThatThrownBy(() -> Name.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void name_equals_test() {
        String input = "heesu";
        Name name = Name.of(input);

        assertThat(name.equals(Name.of("heesu"))).isTrue();
        assertThat(name.equals(input)).isTrue();
    }

    @Test
    void name_toString_test() {
        String input = "heesu";
        Name name = Name.of(input);

        assertThat(name.toString().equals(input)).isTrue();
    }
}
