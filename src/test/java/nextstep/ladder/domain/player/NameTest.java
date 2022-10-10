package nextstep.ladder.domain.player;

import nextstep.ladder.domain.player.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Name 테스트")
public class NameTest {

    @DisplayName("이름은 최대 5글자까지 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "jh", "pobi", "noose"})
    void name(String input) {
        assertDoesNotThrow(() -> new Name(input));
    }

    @DisplayName("이름의 앞 또는 끝 부분에 공백이 포함되어 있다면 제거된다.")
    @Test
    void nameSpace() {
        assertThat(new Name(" noose ")).isEqualTo(new Name("noose"));
    }

    @DisplayName("5글자가 초과되면 예외가 발생한다.")
    @Test
    void nameWhenInputInvalid() {
        assertThatThrownBy(() -> new Name("nooose")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름에 빈 문자열이나 Null값이 들어오면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nameWhenInputNullOrEmpty(String input) {
        assertThatThrownBy(() -> new Name(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
