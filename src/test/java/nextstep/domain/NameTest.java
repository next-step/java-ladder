package nextstep.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class NameTest {
    @ParameterizedTest
    @CsvSource({
        "neojjc"
    })
    @DisplayName("이름은 최대 5글자까지 가능하다.")
    void nameRequirementsTest(String name) {
        Assertions.assertThatThrownBy(
            () -> Name.of(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름은 빈 문자열이 될 수 없다.")
    void nameValidationTest(String name) {
        Assertions.assertThatThrownBy(
            () -> Name.of(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
