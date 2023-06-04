package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PersonsTest {
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @NullAndEmptySource
    void 입력값검증_NullAndEmpty(String names) {
        assertThatThrownBy(() -> {
            Persons persons = Persons.of(names);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름이 입력되지 않았습니다.");
    }

    @Test
    void 입력값검증_입력개수() {
        assertThatThrownBy(() -> {
            Persons persons = Persons.of("jerry");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("이름은 2개 이상 입력되어야 합니다.");
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"jerry, david:2", "jerry, david, joy:3", "jerry, david, joy, james:4"}, delimiter = ':')
    void Persons생성검증(String names, int count) {
        Persons persons = Persons.of(names);

        Assertions.assertThat(persons.getCount()).isEqualTo(count);
    }

    @Test
    void 이름포함() {
        Persons persons = Persons.of("jerry, david");

        Assertions.assertThat(persons.getList("jerry").size()).isEqualTo(1);
    }

    @Test
    void 이름미포함() {
        Persons persons = Persons.of("jerry, david");

        assertThatThrownBy(() -> {
            persons.getList("joy");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력하신 이름이 참여자에 존재하지 않습니다.");
    }

    @Test
    void 이름all() {
        Persons persons = Persons.of("jerry, david, joy");

        Assertions.assertThat(persons.getList("all").size()).isEqualTo(3);
    }
}
