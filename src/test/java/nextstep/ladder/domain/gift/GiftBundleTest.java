package nextstep.ladder.domain.gift;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class GiftBundleTest {

    @Test
    void gift() {
        GiftBundle giftBundle = GiftBundle.from(asList("사과", "토마토", "감"));

        assertThat(giftBundle.gift(0)).isEqualTo(new Gift("사과"));
        assertThat(giftBundle.gift(1)).isEqualTo(new Gift("토마토"));
        assertThat(giftBundle.gift(2)).isEqualTo(new Gift("감"));
    }

}
