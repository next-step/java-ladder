package nextstep.laddergame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerCountTest {

    @ParameterizedTest(name = "참여자는 두 명 이상이다.")
    @ValueSource(ints = {-1, 0, 1})
    public void invalidCountOfPlayerTest(int count) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayerCount.of(count))
                .withMessageContaining(String.valueOf(count));
    }

}