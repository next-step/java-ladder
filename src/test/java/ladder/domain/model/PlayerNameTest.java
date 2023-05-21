package ladder.domain.model;

import ladder.exception.PlayerNameLengthArgumentException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"testset","testttt","testtttttttt","testtttt"})
    public void 글자최대글자_테스트(String names) {
        assertThatThrownBy(() -> {
            new PlayerName(names);
        }).isInstanceOf(PlayerNameLengthArgumentException.class)
                .hasMessageContaining("최대이름 글자를 초과하였습니다.");
    }
}

