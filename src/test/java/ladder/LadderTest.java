package ladder;

import ladder.domain.Ladder;
import ladder.fixture.FixedPointFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {

    @Test
    @DisplayName("사다리 높이만큼 다리를 놓을 수 있다")
    public void ladder_height() {
        assertThat(new Ladder(5, 4, new FixedPointFactory(Arrays.asList(true, false, true))))
            .extracting(Ladder::lines)
            .asList()
            .hasSize(5);
    }

}
