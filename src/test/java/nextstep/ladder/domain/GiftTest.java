package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GiftTest {

    @DisplayName("상품명의 길이가 1미만이라면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] gift: {0}")
    @NullAndEmptySource
    void create_emptyGift_thrownException(String gift) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Gift(gift))
                .withMessage(Gift.EMPTY_GIFT_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "[{index}] giftSize: {0}")
    @ValueSource(ints = {1, 5})
    void listOf(int giftSize) {
        List<Gift> gifts = Gift.listOf(Collections.nCopies(giftSize, "경품"));
        assertThat(gifts.size()).isEqualTo(giftSize);
    }

}
