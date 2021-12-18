package nextstep.ladder.step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DefaultLadderGeneratorTest {

    @Test
    void create() {
        assertThat(new DefaultLadderGenerator(5, new Height(5)).generate()).isInstanceOf(DefaultLadder.class);
    }

}
