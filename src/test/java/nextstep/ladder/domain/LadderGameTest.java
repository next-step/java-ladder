package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Names;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.common.Results;
import nextstep.ladder.domain.exception.NotExistsPlayerNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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
    private static final Names NAMES = Names.of("pobi,honux,crong,jk,hyune");
    private static final Results RESULTS = Results.of("1000,5000,4000,3000,6000");
    private static final LadderGame LADDER_GMAE = LadderGame.of(LINES, NAMES, RESULTS);

    public static Stream<Arguments> result() {
        return Stream.of(
            Arguments.of(LADDER_GMAE, Name.of("pobi"), Result.of("4000")),
            Arguments.of(LADDER_GMAE, Name.of("honux"), Result.of("1000")),
            Arguments.of(LADDER_GMAE, Name.of("crong"), Result.of("5000")),
            Arguments.of(LADDER_GMAE, Name.of("jk"), Result.of("3000")),
            Arguments.of(LADDER_GMAE, Name.of("hyune"), Result.of("6000"))
        );
    }

    @DisplayName("[성공] 사다리 결과")
    @ParameterizedTest
    @MethodSource("result")
    public void result(final LadderGame game, final Name name, final Result expected) {
        // given

        // when
        final Result result = game.getResult(name);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[실패] 존재하지 않는 참여자 이름")
    @ParameterizedTest
    @CsvSource({
        "ppp"
    })
    public void result(final String name) {
        // given

        // when
        Assertions.assertThrows(NotExistsPlayerNameException.class, () -> LADDER_GMAE.getResult(Name.of(name)));

        // then
    }
}
