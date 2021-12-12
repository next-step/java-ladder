package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Person 객체 생성시 Null이나 빈값이 들어갔을 경우")
    void validationNullOrEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Person(input));
    }

}