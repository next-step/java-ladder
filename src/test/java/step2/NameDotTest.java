package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameDotTest {
    @Test
    void create() {
        final NameDot pobi = new NameDot("pobi");
        assertThat(pobi).isEqualTo(new NameDot("pobi"));
    }

    @Test
    void print() {
        final NameDot pobi = new NameDot("pobi");
        assertThat(pobi.print()).isEqualTo("pobi");
    }
}