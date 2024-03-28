package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    void create() {
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름이_비어있는경우_예외를_던진다(String given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(given))
                .withMessage("이름이 비어 있습니다");
    }

    @Test
    void 이름길이가_최대5자를_초과하면_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("tester"))
                .withMessage("이름은 최대 5자를 초과할 수 없습니다");
    }
}
