package laddergame.domain.player;

import laddergame.domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("생성자로 받은 이름을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong"})
    void getName(String expectName) {
        Name name = new Name(expectName);

        assertThat(name.getName()).isEqualTo(expectName);
    }

    @DisplayName("이름이 Null 또는 공백일때 IllegalArgumentException Throw")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyThrowException(String expectName) {
        assertThatThrownBy(() -> new Name(expectName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 Null 이나 공백일 수 없습니다.");
    }

    @DisplayName("이름이 5글자가 넘어가면 IllegalArgumentException Throw")
    @ParameterizedTest
    @ValueSource(strings = {"thisName", "hiMyName"})
    void overFiveLengthNameThrowException(String expectName) {
        assertThatThrownBy(() -> new Name(expectName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 넘을 수 없습니다. - " + expectName);
    }

    @DisplayName("인자로 받은 String이 자신의 값과 같은지 비교")
    @ParameterizedTest
    @CsvSource({"pobi, true", "crong, false"})
    void isSameName(String sameName, boolean result) {
        Name name = new Name("pobi");

        assertThat(name.isSameName(sameName)).isEqualTo(result);
    }
}