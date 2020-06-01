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

class PlayersTests {
    @DisplayName("쉼표로 구분된 문자열을 입력 받아서 일급 콜렉션을 생성할 수 있다.")
    @Test
    void createTest() {
        String inputValue = "poppo, ita, saul";
        Players players = Players.create(inputValue);
        assertThat(players).isNotNull();
        assertThat(players.size()).isEqualTo(3);
    }

    @DisplayName("null이나 빈 문자열로 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"    ", ""})
    void createValidationTest(String invalidValue) {
        assertThatThrownBy(() -> Players.create(invalidValue)).isInstanceOf(PlayerNamesEmptyException.class);
    }

    @DisplayName("현재 객체의 가장 긴 이름의 길이를 알려줄 수 있다.")
    @ParameterizedTest
    @CsvSource(value = { "poppo, ita, saul:5", "pop, ita, saul:4" }, delimiter = ':')
    void getMaxNameLengthTest(String inputValue, int resultSize) {
        Players players = Players.create(inputValue);
        assertThat(players.size()).isEqualTo(3);
        assertThat(players.getMaxNameLength()).isEqualTo(resultSize);
    }

    @DisplayName("이름 순서대로 초기 사다리 위치가 설정된다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2 })
    void locationTest(int nameIndex) {
        String inputValue = "poppo, ita, saul";
        Players players = Players.create(inputValue);
        HorizontalLocation location = players.getLocationOfIndex(nameIndex);
        assertThat(location).isEqualTo(new HorizontalLocation(nameIndex, 3));
    }
}
