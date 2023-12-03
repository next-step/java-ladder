package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    @Test
    @DisplayName("결과 명 중 all은 금지되어 있다.")
    void test1() {
        assertThatThrownBy(() -> new Result("all"))
                .hasMessageContaining("해당 문자는 금지되어 있습니다.(사유: 예약어)");
    }
}