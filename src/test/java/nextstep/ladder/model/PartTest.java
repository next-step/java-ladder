package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public final class PartTest {

    @ParameterizedTest(name = "활성화 여부 : {1} 결과 : {2}")
    @MethodSource("createLadderPart")
    @DisplayName("사다리의 가로부분과 세로 부분을 합칩니다.")
    void crate(boolean isActivate, String result) {
        assertThat(Part.add(Height.create(), new Bar(5,isActivate))).isEqualTo(result);
    }

    static Stream<Arguments> createLadderPart() {
        return Stream.of(
                Arguments.arguments(true, "|-----"),
                Arguments.arguments(false, "|     ")
        );
    }
}
