import ladder.domain.Ladder;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 생성() {
        Ladder ladder = Ladder.create(5, 4);
        assertThat(ladder).isNotNull();
        assertThat(ladder.size()).isEqualTo(4);
    }

    @Test
    public void 연결() {
        Ladder ladder = Ladder.create(5, 4);
        ladder.drawLine(1);
    }
}