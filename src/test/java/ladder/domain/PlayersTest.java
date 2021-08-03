package ladder.domain;

import ladder.exception.DuplicateKeyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    private List<Player> nameToPlayerList(String names) {
        return Arrays.stream(names.split(","))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    @DisplayName("유효성 검사 정상 통과")
    @ValueSource(strings = {
            "pobi,jae,won"
    })
    @ParameterizedTest
    public void ctorTest(String names) {
        assertThatCode(() ->
                new Players(nameToPlayerList(names))
        ).doesNotThrowAnyException();
    }

    @DisplayName("이름 중복")
    @ValueSource(strings = {
            "pobi,jae,won,jae"
    })
    @ParameterizedTest
    public void ctorTest_DuplicateKeyException(String names) {
        assertThatThrownBy(() ->
                new Players(nameToPlayerList(names))
        ).isInstanceOf(DuplicateKeyException.class);
    }
}