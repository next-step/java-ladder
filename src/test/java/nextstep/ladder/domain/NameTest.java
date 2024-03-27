package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 참여하는_사람의_이름_예외를_테스트한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("unicorn"));
    }
}
