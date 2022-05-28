package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {
    @DisplayName("이름은 최대 5글자이다.")
    @Test
    public void name_length() {
        assertThatThrownBy(() -> new PlayerName("hahaha"))
                .isInstanceOf(InvalidPlayerNameException.class)
                .hasMessage("이름은 최대 5글자를 넘을 수 없습니다.");
    }

    @DisplayName("이름은 null이나 빈값일 수 없다.")
    @NullAndEmptySource
    @ParameterizedTest
    public void null_and_empty(String name) {
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(InvalidPlayerNameException.class)
                .hasMessage("이름은 비어있을 수 없습니다.");
    }

    @DisplayName("이름 생성")
    @ValueSource(strings = {"H", "solar"})
    @ParameterizedTest
    public void create(String name) {
        final PlayerName playerName = new PlayerName(name);

        assertThat(playerName).isNotNull();
    }
}
