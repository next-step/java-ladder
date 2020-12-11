package ladder.domain.game;

import ladder.domain.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-12-09.
 */
class LadderResultTest {

    Ladder ladder;
    Names participants;
    Names goals;

    @BeforeEach
    void setUp() {
        //0 1 0 1
        //0 0 1 0
        //0 1 0 0
        //0 0 1 0
        //0 1 0 1

        ladder = Ladder.of(Arrays.asList(
                Line.of(Arrays.asList(false, true, false, true)),
                Line.of(Arrays.asList(false, false, true, false)),
                Line.of(Arrays.asList(false, true, false, false)),
                Line.of(Arrays.asList(false, false, true, false)),
                Line.of(Arrays.asList(false, true, false, true))
        ));
        participants = Names.from("a,b,c,d");
        goals = Names.from("꽝,1등,꽝,2등");
    }

    private static Stream<Arguments> providedResultOfLadder() {
        return Stream.of(
                Arguments.of(Name.from("a"), Name.from("꽝")),
                Arguments.of(Name.from("b"), Name.from("2등")),
                Arguments.of(Name.from("c"), Name.from("꽝")),
                Arguments.of(Name.from("d"), Name.from("1등"))
        );
    }


    @ParameterizedTest
    @MethodSource("providedResultOfLadder")
    void 결과값_가져오기_각자(Name inputParticipant, Name expectedGoal) {
        LadderResult ladderResult = LadderResult.of(participants, ladder.moveAll(goals));

        assertThat(ladderResult.getResultOfOneParticipant(inputParticipant))
                .isEqualTo(expectedGoal);
    }

    @ParameterizedTest
    @MethodSource("providedResultOfLadder")
    void 결과값_가져오기_전체(Name inputParticipant, Name expectedGoal) {
        LadderResult ladderResult = LadderResult.of(participants, ladder.moveAll(goals));

        assertThat(ladderResult.getResultOfAll().get(inputParticipant))
                .isEqualTo(expectedGoal);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "나", "ab"})
    void 결과값_찾기시_잘못된_참가자_이름을_입력하면_예외처리(String findName) {
        LadderResult ladderResult = LadderResult.of(participants, ladder.moveAll(goals));

        assertThatThrownBy(() ->
                    ladderResult.getResultOfOneParticipant(Name.from(findName))
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ladderResult.MESSAGE_NAME_NOT_MATCH_PARTICIPANT_LIST);
    }

}
