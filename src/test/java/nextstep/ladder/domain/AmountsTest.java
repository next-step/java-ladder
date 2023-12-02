package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("ResultAmounts 은 아무런 결과 금액이 주어지지 않으면 예외를 던진다.")
    void newObject_nullAndEmpty_throwsException(String nullAndEmpty) {
        assertThatThrownBy(
                () -> new Amounts(nullAndEmpty)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
