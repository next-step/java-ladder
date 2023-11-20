package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    @DisplayName("정상적인 범위의 이름을 생성하면 정상적으로 생성된다.")
    void createName() {
        String inputName = "엄태권";

        Name name = new Name(inputName);

        assertThat(name).isEqualTo(new Name(inputName));
    }

    @ParameterizedTest(name = "비어있거나 Null인 이름을 생성하면 오류가 발생한다.")
    @NullAndEmptySource
    void createName_null_empty(String inputName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(inputName))
                .withMessage("비어있거나 공란의 이름은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("이름의 글자가 5글자를 초과하면 오류가 발생한다.")
    void createName_over_5length() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("여섯글자이름"))
                .withMessage("이름은 5글자를 초과하여 입력할 수 없습니다.");
    }
}