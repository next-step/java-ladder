package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GiftNameTest {

    @Test
    void create() {
        assertThat(GiftName.from("aaa")).isNotNull();
    }

    @Test
    @DisplayName(value = "선물이 공백이면 IllegalArgumentException")
    void isBlank() {
        assertThatThrownBy(() -> GiftName.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}