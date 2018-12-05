package net.chandol.ladder.v2.domain.prize;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrizeTest {

    @Test
    public void getFixedCenterValue() {
        Prize prize = new Prize("꽝");

        String fixedLengthName = prize.getPrizeWithFixedLength();
        Assertions.assertThat(fixedLengthName).isEqualTo("  꽝  ");
    }
}