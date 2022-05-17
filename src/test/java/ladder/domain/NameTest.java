package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("Name 객체를 생성한다.")
    void Name_이름_생성() {
        assertThat(new Name("wu2ee")).isNotNull().isInstanceOf(Name.class);
    }

    @ParameterizedTest
    @DisplayName("이름 길이가 5자를 초과하는 경우 예외가 발생한다.")
    @ValueSource(strings = {"wu2eee", "wu2eeeeeeee"})
    void Name_이름_길이가_5자_초과(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 null 또는 비어있을 경우 예외가 발생한다.")
    void Name_이름_유효성_검사(String name) {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "wu2ee, 5",
            "pobi, 4",
            "mbc, 3"
    })
    @DisplayName("이름의 길이를 정상적으로 반환한다.")
    void length_이름_길이(String name, int length) {
        assertThat(new Name(name).length()).isEqualTo(length);
    }
}
