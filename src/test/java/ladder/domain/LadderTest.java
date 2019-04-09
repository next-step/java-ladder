package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LadderTest {

    @Test
    public void 사다리생성() {
        Ladder result = new Ladder(2, 2);
        Assertions.assertThat(result.getLines().size()).isEqualTo(2);
        Assertions.assertThat(result.getLines().get(0).getPoints().size()).isEqualTo(1);
        Assertions.assertThat(result.getLines().get(1).getPoints().size()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리생성_실패() {
          new Ladder(3, 1);
    }

}