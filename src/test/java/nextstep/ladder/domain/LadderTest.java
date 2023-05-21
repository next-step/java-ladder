package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        People people = new People(new String[]{"pobi", "honux", "crong", "jk"});
        int height = 5;

        Ladder ladder = new Ladder(people, height);
        assertThat(ladder.lines().value().size()).isEqualTo(height);
    }
}
