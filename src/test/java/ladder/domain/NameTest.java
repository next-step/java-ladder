package ladder.domain;

import ladder.domain.exception.NameLengthOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("이름 앞뒤에 공백이 있으면 제거된다.")
        @ParameterizedTest
        @ValueSource(strings = {" apple ", "\napple\n", "   apple   "})
        void trim(String value) {
            assertThat(new Name(value)).isEqualTo(new Name("apple"));
        }

        @DisplayName("null 값이 입력되면 예외가 발생한다.")
        @ParameterizedTest
        @NullSource
        void validate_null(String source) {
            assertThatThrownBy(() -> new Name(source))
                    .isExactlyInstanceOf(NameLengthOutOfRangeException.class)
                    .hasMessage("이름 길이가 범위를 벗어났습니다. 오류이름 : 비어있음");
        }

        @DisplayName("이름 길이가 1 ~ 5를 벗어나면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"", "banana"})
        void validate_length(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isExactlyInstanceOf(NameLengthOutOfRangeException.class)
                    .hasMessage("이름 길이가 범위를 벗어났습니다. 오류이름 : " + name);
        }
    }
}

