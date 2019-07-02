package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class RungTest {

    @Test
    void rungTest() {
        Rung rung = new Rung(true);
        assertThat(rung.isRung()).isTrue();
    }
}
