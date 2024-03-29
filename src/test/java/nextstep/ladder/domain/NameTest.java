package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @Test
    void 사용자의_이름을_생성한다() {
        assertThatNoException().isThrownBy(() -> new Name("pobi"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"unicorn", "ladder"})
    @NullAndEmptySource
    void 참여하는_사람의_이름_예외를_테스트한다(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }
}
