package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerNameTest {

    @ParameterizedTest(name = "참여자의 이름은 5자 이내이다.")
    @ValueSource(strings = {"", "abcdef"})
    @NullSource
    public void playerNameLengthTest(String invalidNameInput) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayerName.of(invalidNameInput))
                .withMessageContaining(String.valueOf(invalidNameInput));
    }

    @ParameterizedTest(name = "참여자 이름을 생성 할 수 있다.")
    @ValueSource(strings = {"a", "abcde"})
    public void createPlayerNameTest(String name) {
        PlayerName playerName = PlayerName.of(name);
        assertThat(playerName.toString())
                .contains(name);
    }

}