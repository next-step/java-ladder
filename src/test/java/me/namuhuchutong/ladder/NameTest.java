package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.domain.wrapper.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @DisplayName("이름의 크기는 5자를 넘을 수 없다.")
    @Test
    void name_length_should_be_under_five() {
        String given = "abcdef";

        assertThatThrownBy(() -> new Name(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("5자 이하의 이름은 정상적으로 객체를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "a,a",
            "ab,ab",
            "abc,abc",
            "abcd,abcd",
            "abcde,abcde"
    })
    void create_name_object_when_name_length_under_five(String given, String expected) {
        Name created = new Name(given);
        String actual = created.getName();

        assertThat(actual).isEqualTo(expected);
    }
}
