package ladder.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    private static final String EXCEPTION_MESSAGE ="이름은 1자 이상 5자 이하로 입력 해주세요";

    @Test
    void 공란_이름은_예외() {
        String exceptionMessage = "이름은 1자 이상 5자 이하로 입력 해주세요";
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);

        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);

        assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);
    }

    @Test
    void 이름이_5자를_초과하면_예외() {
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEPTION_MESSAGE);
    }
}