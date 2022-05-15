package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    void Name_이름_생성() {
        assertThat(new Name("wu2ee")).isNotNull().isInstanceOf(Name.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"wu2eee", "wu2eeeeeeee"})
    void Name_이름_길이가_5자_초과하는_경우(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void Name_이름_유효성_검사_0글자(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "wu2ee, 5",
            "pobi, 4",
            "mbc, 3"
    })
    void length_이름_길이(String name, int length) {
        assertThat(new Name(name).length()).isEqualTo(length);
    }
}
