package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNamesEmptyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNamesTests {
    @DisplayName("쉼표로 구분된 문자열을 입력 받아서 일급 콜렉션을 생성할 수 있다.")
    @Test
    void createTest() {
        String inputValue = "poppo, ita, saul";
        PlayerNames playerNames = PlayerNames.create(inputValue);
        assertThat(playerNames).isNotNull();
        assertThat(playerNames.size()).isEqualTo(3);
    }

    @DisplayName("null이나 빈 문자열로 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"    ", ""})
    void createValidationTest(String invalidValue) {
        assertThatThrownBy(() -> PlayerNames.create(invalidValue)).isInstanceOf(PlayerNamesEmptyException.class);
    }

    @DisplayName("현재 객체의 가장 긴 이름의 길이를 알려줄 수 있다.")
    @ParameterizedTest
    @CsvSource(value = { "poppo, ita, saul:5", "pop, ita, saul:4" }, delimiter = ':')
    void getMaxNameLengthTest(String inputValue, int resultSize) {
        PlayerNames playerNames = PlayerNames.create(inputValue);
        assertThat(playerNames.size()).isEqualTo(3);
        assertThat(playerNames.getMaxNameLength()).isEqualTo(resultSize);
    }
}
