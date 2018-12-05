package net.chandol.ladder.v2.domain.prize;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrizesTest {

    @Test
    public void 상금문자열생성() {
        Prizes prizes = Prizes.of("꽝", "3000");

        String prizesStr = prizes.createPrizesString();
        Assertions.assertThat(prizesStr).isEqualTo("  꽝   3000 ");
    }
}