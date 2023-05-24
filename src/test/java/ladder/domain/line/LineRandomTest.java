package ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import ladder.domain.line.LineRandom;
import org.junit.jupiter.api.Test;

public class LineRandomTest {

    LineRandom random = LineRandom.of(new Random());

    @Test
    void 랜덤리스트() {
        List<Boolean> actual = random.listSizeOf(3);
        assertThat(actual).hasSize(3);
    }

}
