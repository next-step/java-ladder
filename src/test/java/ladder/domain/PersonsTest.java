package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PersonsTest {
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @NullAndEmptySource
    void 입력값검증_NullAndEmpty(String names) {
        assertThatThrownBy(() -> {
            Persons persons = new Persons(names);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름이 입력되지 않았습니다.");
    }

    @Test
    void 입력값검증_입력개수() {
        assertThatThrownBy(() -> {
            Persons persons = new Persons("jerry");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름은 2개 이상 입력되어야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"jerry, david:2", "jerry, david, joy:3", "jerry, david, joy, james:4"}, delimiter = ':')
    void Persons생성검증(String names, int count) {
        Persons persons = new Persons(names);

        Assertions.assertThat(persons.getCount()).isEqualTo(count);
    }
}
