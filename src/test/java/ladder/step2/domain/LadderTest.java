package ladder.step2.domain;

import ladder.step2fixture.domain.LadderFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리 생성")
    void create() {
        assertThat(LadderFixture.LADDER).isNotNull();
    }
}
