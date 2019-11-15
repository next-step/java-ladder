package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void 생성() {
        Lines lines = new Lines();
        Ladder ladder = new Ladder(lines);
        assertThat(ladder).isEqualTo(new Ladder(lines));
    }
}
