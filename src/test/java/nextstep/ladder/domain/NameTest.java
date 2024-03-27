package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"unicorn", "ladder"})
    @NullAndEmptySource
    void 참여하는_사람의_이름_예외를_테스트한다(final String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }
}
