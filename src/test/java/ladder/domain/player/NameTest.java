package ladder.domain.player;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    private static final String OVERSIZE_NAME = "경계값 이름";

    @ParameterizedTest
    @NullAndEmptySource
    void Name은_이름_없이_생성_할_경우_예외를_발생_시킨다(String name) {
        assertThatThrownBy(
                () -> Name.valueOf(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Name은_최대값_보다_크게_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> Name.valueOf(OVERSIZE_NAME)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
