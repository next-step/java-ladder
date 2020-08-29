package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameResultTest {

    @DisplayName("LadderGameResult 테스트")
    @ParameterizedTest
    @MethodSource("makeGetResultByData")
    void getResultBy(String participantNames, String ladderRewardInput, String checkParticipant, String expectedResult) {
        Participants participants = Participants.from(participantNames);
        LadderReward ladderReward = LadderReward.of(participants, ladderRewardInput);
        Ladder ladder = Ladder.of(4, participants, new LineRepeatGenerator());

        LadderGameResult ladderGameResult = participants.calculateResult(ladder, ladderReward);
        Map<Name, String> actualResult = ladderGameResult.getResult();

        assertThat(ladderGameResult).isNotNull();
        assertThat(actualResult.size()).isEqualTo(participants.getNumber());
        assertThat(actualResult.values()).containsAll(Arrays.asList(ladderRewardInput.split(",")));
        assertThat(ladderGameResult.getBy(checkParticipant)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> makeGetResultByData() {
        return Stream.of(
                Arguments.of("tt,dd", "1등,2등","tt", "1등"),
                Arguments.of("nana,toto,dodo", "1등,2등,3등", "toto", "2등"),
                Arguments.of("coco,momo,lulu,lala", "1등,2등,3등,4등", "lala", "1등")
        );
    }
}