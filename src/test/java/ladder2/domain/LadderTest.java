package ladder2.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder2.domain.factory.LadderRowFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    private static final int ANY_POSITIVE = 5;

    @Test
    @DisplayName("성공적으로 인스턴스화된다")
    void new_success() {
        List<LadderRow> rows = List.of(LadderRowFactory.generate(ANY_POSITIVE));
        assertThatNoException()
            .isThrownBy(() -> new Ladder(rows));
    }

    @Test
    void new_empty_exception() {
        assertThatThrownBy(() -> new Ladder(List.of()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void new_not_same_size_columns_exception() {
        List<LadderRow> rows = List.of(
            LadderRowFactory.generate(3),
            LadderRowFactory.generate(4)
        );
        assertThatThrownBy(() -> new Ladder(rows))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
