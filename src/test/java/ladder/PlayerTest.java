package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import ladder.model.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"jane","john","kai","mimi","sa"})
    @DisplayName("이름이 5글자 이하이고 빈 값이 아니라면 Player를 생성한다.")
    void validateNameTest(String name) {
        Player player = new Player(name);
        assertThat(player.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 빈 값이거나 null이라면 예외가 발생한다.")
    void validateNameEmptyTest(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"nancyk","channel","aladdinn","garyson","jennie"})
    @DisplayName("이름이 5글자 이상이라면 예외를 발생시킨다.")
    void validateNameLengthOverFiveTest(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 넘길 수 없습니다.");
    }
}
