package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FormattedNameTest {
    @Test
    void format() {
        final FormattedName helloworld = new FormattedName("helloworld", 5);
        assertThat(helloworld.print()).isEqualTo("hello");
    }
}