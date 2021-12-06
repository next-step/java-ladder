package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    private Map<Integer, Integer> value;
    @BeforeEach
    void setUp() {
        value = new HashMap<>();
        value.put(3, 1);
        value.put(2, 0);
        value.put(1, 3);
        value.put(0, 2);
    }

    @Test
    void create() {
        assertThat(new LadderResult(value)).isEqualTo(new LadderResult(value));
    }

    @ParameterizedTest
    @MethodSource("resultSource")
    @DisplayName("LadderResult 는 User 와 협력하여 해당 User 의 결과를 반환할 수 있다.")
    void result(User user, int result) {
        // given
        LadderResult ladderResult = new LadderResult(value);

        // then
        assertThat(ladderResult.result(user) == result).isTrue();
    }

    static Stream<Arguments> resultSource() {
        return Stream.of(
                Arguments.of(new User("pobi", 0), 2),
                Arguments.of(new User("honux", 1), 3),
                Arguments.of(new User("crong", 2), 0),
                Arguments.of(new User("jk", 3), 1)
        );
    }
}
