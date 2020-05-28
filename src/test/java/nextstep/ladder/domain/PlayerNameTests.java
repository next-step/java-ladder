package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTests {
    @DisplayName("String 값을 전달받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        PlayerName playerName = new PlayerName("poppo");
        assertThat(playerName).isNotNull();
    }

    @DisplayName("5 글자를 넘는 값으로 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"thisistoolong", "666666"})
    void createLengthValidationTest(String invalidNameValue) {
        assertThatThrownBy(() -> new PlayerName(invalidNameValue)).isInstanceOf(PlayerNameLengthException.class);
    }

    @DisplayName("null이나 길이가 0이거나 빈 문자열로는 객체를 생성할 수 없다.")
    @NullSource
    @ParameterizedTest
    @ValueSource(strings = {"", "     "})
    void createEmptyValidationTest(String invalidNameValue) {
        assertThatThrownBy(() -> new PlayerName(invalidNameValue)).isInstanceOf(PlayerNameEmptyException.class);
    }
}
