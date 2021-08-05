package ladder.domain.player;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @ValueSource(strings = {"AA,BB"})
    @ParameterizedTest
    @DisplayName("생성 성공")
    public void ctorTest(String strNames) {
        assertThatCode(() -> new Players(toList(strNames)))
                .doesNotThrowAnyException();
    }

    @ValueSource(strings = {"AA,AA"})
    @ParameterizedTest
    @DisplayName("중복 이름 생성 실패")
    public void ctorTest_IllegalState(String strNames) {
        assertThatThrownBy(() -> new Players(toList(strNames)))
                .isInstanceOf(IllegalStateException.class);
    }

    private List<Player> toList(String strNames) {
        return Arrays.stream(strNames.split(","))
                .map(Name::new)
                .map(Player::new)
                .collect(Collectors.toList());
    }
}