package nextstep.ladder.gift;

import nextstep.ladder.domain.exception.InvalidNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GiftTest {

    @DisplayName("상품명의 길이가 1미만이라면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] gift: {0}")
    @NullAndEmptySource
    void create_emptyName_throwsException(String gift) {
        assertThatThrownBy(() -> new Gift(gift))
                .isInstanceOf(InvalidNameLengthException.class);
    }

}
