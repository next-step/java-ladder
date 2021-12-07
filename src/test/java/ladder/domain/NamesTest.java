package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {

    @Test
    void create() {
        Names names = new Names("pobi, honux, crong, jk");

        assertThat(names.getNames()).hasSize(4);
    }



}
