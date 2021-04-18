package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    void create() {
        assertThatCode(() -> Prize.of("pobi")).doesNotThrowAnyException();
    }

    @DisplayName("상품 이름은 최대 5글자")
    @Test
    void validNameLength() {
        assertThatThrownBy(() -> Prize.of("pobi77")).isInstanceOf(NameLengthExceededException.class);
    }
}
