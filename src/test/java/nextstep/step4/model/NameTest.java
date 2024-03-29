package nextstep.step4.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    void create() {
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }

    @Test
    void 널이거나_공백인경우_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(""))
                .withMessage("빈 이름은 허용하지 않습니다");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(null))
                .withMessage("빈 이름은 허용하지 않습니다");
    }

    @Test
    void 최대길이_초과한경우_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("tester"))
                .withMessage("이름은 최대 " + Name.MAX_LENGTH + "까지 가능합니다");
    }
}
