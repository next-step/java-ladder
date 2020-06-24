package ladder.domain.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlayingTest {
    @ParameterizedTest
    @MethodSource("playersAndPrizes")
    @DisplayName("참여자 갯수와 결과 갯수가 동일하지 않은 경우 Playing 객체를 생성할 수 없다.")
    void must_be_same_size(Items players, Items prizes) {
        assertThatThrownBy(() -> Playing.of(players, prizes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 갯수와 결과 갯수가 동일해야 합니다.");
    }

    static Stream<Arguments> playersAndPrizes() {
        return Stream.of(
                arguments(Items.of(Arrays.asList("pobi", "honux")), Items.of(Arrays.asList("pobi", "honux", "crong"))),
                arguments(Items.of(Arrays.asList("pobi", "honux", "crong")), Items.of(Arrays.asList("pobi", "honux", "crong", "jk"))));
    }
}