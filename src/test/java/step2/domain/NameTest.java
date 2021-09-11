package step2.domain;

import org.junit.jupiter.api.Test;
import step2.dto.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    void createFail() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isExactlyInstanceOf(RuntimeException.class);
    }

    @Test
    void createSunccess() {
        final String nameValue = "abcde";
        final Name name = new Name(nameValue);
        assertThat(name).isEqualTo(new Name(nameValue));
    }
}