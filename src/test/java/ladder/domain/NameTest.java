package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @DisplayName("1 ~ 5글자가 아니면 오류 발생")
    @ValueSource(strings = {" ", "123456"})
    @NullAndEmptySource
    @ParameterizedTest
    public void valueOfExceptionThrown(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Name.valueOf(name));
    }

    @DisplayName("입력 값의 양끝 공백 제거")
    @Test
    public void valueOfTrim() {
        Name name = Name.valueOf(" A ");
        assertThat(name.getValue()).isEqualTo("A");
    }
}
