package ladder.step4.domain;

import ladder.step4.domain.strategy.DirectionStrategy;
import ladder.step4.domain.strategy.ToggleDirectionStrategy;
import ladder.step4.exception.NotParticipantException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {

    private static final Participants participants = Participants.of("aa,bb,cc,dd");
    private static final LadderResults ladderResults = LadderResults.of("1,2,3,4", participants);
    private static final LadderHeight ladderHeight = LadderHeight.valueOf(3);
    private static final Ladder ladder = Ladder.of(participants, ladderHeight, ToggleDirectionStrategy.getInstance());
    private static final LadderGame ladderGame = LadderGame.of(
        LadderGameExecutor.execute(participants, ladderResults, ladder)
    );

    @DisplayName("사다리의 결과 확인시 잘못된 참여자를 입력할 경우 NotParticipantException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 참여자_검증_테스트(String target) {
        assertThatExceptionOfType(NotParticipantException.class)
            .isThrownBy(() -> ladderGame.getResultOfString(target));
    }


    @DisplayName("사다리의 결과를 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderGameAndTarget")
    void 사다리_게임_결과_테스트(LadderGame ladderGame, Participant participant, LadderResult expected) {
        assertEquals(expected, ladderGame.getResult(participant));
    }

    private static Stream<Arguments> provideLadderGameAndTarget() {
        return Stream.of(
            Arguments.of(ladderGame, Participant.valueOf("aa"), LadderResult.valueOf("2")),
            Arguments.of(ladderGame, Participant.valueOf("bb"), LadderResult.valueOf("1")),
            Arguments.of(ladderGame, Participant.valueOf("cc"), LadderResult.valueOf("4")),
            Arguments.of(ladderGame, Participant.valueOf("dd"), LadderResult.valueOf("3"))
        );
    }
}
