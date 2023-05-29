package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        int verticalLineCount = 4;
        int height = 5;

        Ladder ladder = new Ladder(verticalLineCount, height);
        assertThat(ladder.lines().value().size()).isEqualTo(height);

    }
}
