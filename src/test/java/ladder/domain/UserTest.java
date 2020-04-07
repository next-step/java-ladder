package ladder.domain;

import ladder.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class UserTest {

    @Test
    void canCreate() {
        new User("pobi");
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 IllegalArgumentException 이 발생.")
    @ParameterizedTest
    @NullAndEmptySource
    void testEmptyOrNull(final String inputText) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User(inputText));
    }

    @DisplayName(value = "5글자 이상을 입력할 경우 IllegalArgumentException 이 발생.")
    @ParameterizedTest
    @ValueSource(strings = {"이세상코딩이아니다"})
    void numberCreate(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new User(textInput));
    }


}
