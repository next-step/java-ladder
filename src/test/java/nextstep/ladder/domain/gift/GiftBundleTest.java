package nextstep.ladder.domain.gift;

import nextstep.ladder.domain.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class GiftBundleTest {

    @Test
    void gift() {
        //given
        List<Gift> gifts = asList(new Gift("사과"), new Gift("토마토"), new Gift("감"));
        GiftBundle giftBundle = new GiftBundle(gifts);

        //when
        Gift gift = giftBundle.gift(new Position(0));

        //then
        assertThat(gift).isEqualTo(new Gift("사과"));
    }

}
