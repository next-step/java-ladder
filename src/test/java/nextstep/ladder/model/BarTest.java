package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BarTest {

    @ParameterizedTest(name = "활성화 여부 : {1} 결과 : {2}")
    @MethodSource("createLadderBar")
    @DisplayName("사다리의 가로 라인을 생성합니다.")
    void create(boolean isActivate, String result) {
        Bar bar = new Bar(5, isActivate);
        assertThat(bar.toString()).isEqualTo(result);
    }

    static Stream<Arguments> createLadderBar() {
        return Stream.of(
                Arguments.arguments(true, "-----"),
                Arguments.arguments(false, "     ")
        );
    }
}