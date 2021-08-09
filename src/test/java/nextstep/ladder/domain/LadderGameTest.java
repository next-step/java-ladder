package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("사다리 게임")
class LadderGameTest {

    private static final Lines LINES = new Lines(Arrays.asList(
        Line.of(Arrays.asList(false, true, false, false, true, false)),
        Line.of(Arrays.asList(false, true, false, true, false, false)),
        Line.of(Arrays.asList(false, false, true, false, true, false)),
        Line.of(Arrays.asList(false, false, true, false, true, false)),
        Line.of(Arrays.asList(false, true, false, true, false, false)),
        Line.of(Arrays.asList(false, false, true, false, true, false)))
    );

    private static final List<Name> NAMES = Arrays.stream("pobi,honux,crong,jk,hyune".split(","))
        .map(Name::of)
        .collect(Collectors.toList());

    private static final List<Result> RESULTS = Arrays.stream("1000,5000,4000,3000,6000".split(","))
        .map(Result::of)
        .collect(Collectors.toList());

    public static Stream<Arguments> result() {
        return Stream.of(
            Arguments.of(LadderGame.of(LINES, NAMES, RESULTS), Name.of("pobi"), Result.of("4000")),
            Arguments.of(LadderGame.of(LINES, NAMES, RESULTS), Name.of("honux"), Result.of("1000")),
            Arguments.of(LadderGame.of(LINES, NAMES, RESULTS), Name.of("crong"), Result.of("5000")),
            Arguments.of(LadderGame.of(LINES, NAMES, RESULTS), Name.of("jk"), Result.of("3000")),
            Arguments.of(LadderGame.of(LINES, NAMES, RESULTS), Name.of("hyune"), Result.of("6000"))
        );
    }

    @DisplayName("사다리 결과")
    @ParameterizedTest
    @MethodSource("result")
    public void result(final LadderGame game, final Name name, final Result expected) {
        // given

        // when
        final Result result = game.getResult(name);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
