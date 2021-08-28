package ladder.domain;

import ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @ParameterizedTest
    @DisplayName("입력받는 사다리 높이가 0 이하일 경우 사다리 생성 예외생 발생")
    @MethodSource("ladderProviders")
    void createLadderException(int height, int countOfPerson) {
        assertThatThrownBy(() -> new Ladder(height, countOfPerson))
                .isInstanceOf(LadderException.class);
    }

    static Stream<Arguments> ladderProviders() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(-1, 1)
        );
    }


    @ParameterizedTest
    @DisplayName("사다리 생성 테스트")
    @MethodSource("createLadderProviders")
    void createLadderTest(int height, int countOfPerson, int expected) {
        Ladder ladder = new Ladder(height, countOfPerson);
        int actual = ladder.getLines().size();
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> createLadderProviders() {
        return Stream.of(
                Arguments.of(3, 3, 3),
                Arguments.of(5, 5, 5)
            );
    }
}