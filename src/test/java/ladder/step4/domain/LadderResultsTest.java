package ladder.step4.domain;

import ladder.step4.exception.LadderResultSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderResultsTest {

    @DisplayName("참여자의 수와 결과의 수가 일치하지 않을 경우 LadderResultSizeException 발생")
    @ParameterizedTest
    @MethodSource("provideParticipantsAndResults")
    void 결과_수_검증_테스트(String ladderResults, Participants participants) {
        assertThatExceptionOfType(LadderResultSizeException.class)
            .isThrownBy(() -> LadderResults.of(ladderResults, participants));
    }

    private static Stream<Arguments> provideParticipantsAndResults() {
        Participants participants = Participants.of("aa,bb,cc");
        return Stream.of(
            Arguments.of("1,2", participants),
            Arguments.of("1,2,3,4", participants)
        );
    }

    @DisplayName("LadderResults에 LadderResult가 존재하는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderResultsOfLadderResult")
    void 결과_존재_확인_테스트(LadderResults ladderResults, LadderResult ladderResult) {
        assertEquals(
            ladderResult,
            ladderResults.stream()
                         .filter(v -> v == ladderResult)
                         .findAny()
                         .orElse(null));
    }

    private static Stream<Arguments> provideLadderResultsOfLadderResult() {
        LadderResults ladderResults = LadderResults.of("aa,bb,cc", Participants.of("1,2,3"));
        return Stream.of(
            Arguments.of(ladderResults, LadderResult.valueOf("aa")),
            Arguments.of(ladderResults, LadderResult.valueOf("bb")),
            Arguments.of(ladderResults, LadderResult.valueOf("cc"))
        );
    }
}
