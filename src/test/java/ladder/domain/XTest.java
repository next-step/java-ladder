package ladder.domain;

import ladder.exception.NotAllowedNegativeNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.X.NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.*;

public class XTest {

    @Test
    @DisplayName("생성 성공")
    void create() {
        X x = new X(0);
        X expected = new X();

        assertThat(x).isEqualTo(expected);
    }

    @Test
    @DisplayName("생성 실패: 음수일 수 없다.")
    void create_음수_실패() {
        assertThatThrownBy(() -> {
            X x = new X(-1);
        }).isInstanceOf(NotAllowedNegativeNumber.class)
                .hasMessage(NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE);
    }
}
