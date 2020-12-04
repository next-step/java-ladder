package domain;

import ladder.domain.Persons;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PersonsTest {

    private Persons personsTest;

    @ParameterizedTest
    @DisplayName("이름이 Null이거나 Empty인경우 예외를 던진다.")
    @NullAndEmptySource
    void checkNullOrEmpty(String name) {
        assertThatThrownBy(() ->
                personsTest = new Persons(name)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputNames());
    }

    @ParameterizedTest
    @DisplayName("구분자만 넣고 이름 입력 안했을 시 예외를 던진다")
    @ValueSource(strings = {",,,", ",", ",,,"})
    @NullAndEmptySource
    void checkInputName(String name) {
        assertThatThrownBy(() ->
                personsTest = new Persons(name)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputNames());
    }
}
