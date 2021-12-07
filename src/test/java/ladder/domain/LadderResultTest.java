package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    private List<Position> value;

    @BeforeEach
    void setUp() {
        value = new ArrayList<>();
        value.add(new Position(2));
        value.add(new Position(3));
        value.add(new Position(0));
        value.add(new Position(1));
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
        assertThat(ladderResult.result(user)).isEqualTo(new Position(result));
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
