package ladder.domain;

import ladder.exception.NotAllowedNegativeNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.exception.NotAllowedNegativeNumber.NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class YTest {

    @Test
    @DisplayName("생성 성공")
    void create() {
        Y y = new Y(0);
        Y expected = new Y();

        assertThat(y).isEqualTo(expected);
    }

    @Test
    @DisplayName("생성 실패: 음수일 수 없다.")
    void create_음수_실패() {
        assertThatThrownBy(() -> {
            Y y = new Y(-1);
        }).isInstanceOf(NotAllowedNegativeNumber.class)
                .hasMessage(NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE);
    }
}
