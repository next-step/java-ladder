package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    @Test
    public void create() {
        final String namesInput = "pobi,honux,crong,jk";

        assertThat(new Names(namesInput)).isEqualTo(new Names(namesInput));
    }
}
