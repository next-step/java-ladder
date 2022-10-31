package ladder.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class UserInputTest {
    @DisplayName("이름이 null 이거나 공백이면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void constructor_when_null_or_empty(String names) {
        assertThatThrownBy(() -> new MockUserInput(names).getUserNames(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name cannot be null or blank.");
    }

    @DisplayName("이름의 길이가 최대 사이즈를 넘어가면 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void constructor_when_invalid_length() {
        int maxNameLength = 3;
        assertThatThrownBy(() -> new MockUserInput("abcdefg,abc").getUserNames(maxNameLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The maximum length of a name cannot exceed "+ maxNameLength +" characters.");
    }
}

class MockUserInput extends UserInput {
    private final String names;

    MockUserInput(String names) {
        this.names = names;
    }

    @Override
    String makeNames() {
        return names;
    }
}
