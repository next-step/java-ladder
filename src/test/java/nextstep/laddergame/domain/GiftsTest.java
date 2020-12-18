package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GiftsTest {

    @Test
    void create() {
        assertThat(Gifts.of(3,"1등,2등,3등")).isNotNull();
    }

    @Test
    @DisplayName(value = "선물은 게임 참가자의 숫자만큼 존재해야 함. 그렇지 않을 경우 IllegalArgumentException")
    void valid_CountOfGift() {
        assertThatThrownBy(() -> Gifts.of(2,"a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Gifts.of(4,"a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}