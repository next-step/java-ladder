package ladder;

import ladder.model.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {
    @DisplayName("이름이 같은 Name 비교 시 참을 리턴한다")
    @Test
    void equals() {
        Name name1 = new Name("Name");
        Name name2 = new Name("Name");

        assertThat(name1).isEqualTo(name2);
    }

    @DisplayName("null 또는 빈 문자열은 이름으로 허용하지 않는다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyString(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(input))
                .withMessageMatching("유효하지 않은 이름입니다.");
    }

    @DisplayName("5자가 넘은 이름은 허용하지 않는다")
    @Test
    void nameLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name("FAIL_NAME"))
                .withMessageMatching("이름은 최대 5글자까지 허용합니다.");
    }
}
