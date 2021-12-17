package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderWidthTest {

    @Test
    void create() {
        LadderWidth width = new LadderWidth(3);
        Assertions.assertThat(width).isEqualTo(new LadderWidth(3));
    }

    @Test
    @DisplayName("넓이가 0 이하 값 검증 -> IllegalArgumentException")
    void valid() {
        assertThatThrownBy(() -> new LadderWidth(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("넓이가 0 이상인 값 - 정상")
    void invalid() {
        assertThatCode(() -> new LadderWidth(1))
                .doesNotThrowAnyException();
    }

}