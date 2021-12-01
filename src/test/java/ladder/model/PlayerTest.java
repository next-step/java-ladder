package ladder.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @ParameterizedTest
    @ValueSource(strings = {"test11", "test111", "test1111"})
    void nameLengthOverFiveException(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(name))
                .withMessage("이름 길이는 5를 넘으면 안됩니다.");
    }

}