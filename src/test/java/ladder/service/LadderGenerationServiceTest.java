package ladder.service;

import ladder.domain.MatchingItems;
import ladder.domain.Ladder;
import ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGenerationServiceTest {

    @Test
    @DisplayName("정상실행 - 서비스 실행 결과 참가자 수 검증")
    void participantCount() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when
        Participants participants = service.registerParticipants("pobi,honux,crong,jk");

        // then
        assertThat(4).isEqualTo(participants.getCount());
    }

    @Test
    @DisplayName("정상실행 - 서비스 실행 결과 사다리 높이 검증")
    void ladderHeight() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when
        Ladder ladder = service.generateLadder(4, 5);

        // then
        assertThat(5).isEqualTo(ladder.getLines().size());
    }

    @Test
    @DisplayName("참가자 정보 미입력")
    void participantsIsNull() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.registerParticipants(null))
                .withMessageMatching("참가자 이름을 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("사다리 높이")
    void validateLadderHeight(int ladderHeight) {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateLadder(4, ladderHeight))
                .withMessageMatching("사다리의 높이는 최소 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1})
    @DisplayName("사다리 너비")
    void validateLadderWidth(int ladderWidth) {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateLadder(ladderWidth, 5))
                .withMessageMatching("사다리의 너비는 최소 2 이상이어야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("게임결과 생성 - null 또는 공백입력")
    void nullOrEmpty(String gameResultNames) {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateMatchingItems(gameResultNames, 5))
                .withMessageMatching("게임 결과를 입력해 주세요.");
    }

    @Test
    @DisplayName("게임 결과와 참가자 수가 일치하지 않을 때")
    void participantsCount_invalid() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateMatchingItems("꽝,5000,꽝,3000", 5))
                .withMessageMatching("게임 결과 수는 참가자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("게임 결과에 빈 값 또는 공백 존재")
    void gameResultNames_hasEmpty() {
        // given
        LadderGenerationService service = new LadderGenerationService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateMatchingItems("꽝,,   ,3000", 4))
                .withMessageMatching("유효하지 않은 결과값이 존재합니다. 입력값을 확인해주세요.");
    }

    @Test
    @DisplayName("게임결과 정상생성 테스트")
    void gameResults() {
        // given
        LadderGenerationService service = new LadderGenerationService();
        String gameResultNames = "꽝,5000,꽝,3000";

        // when
        MatchingItems matchingItems = service.generateMatchingItems(gameResultNames, 4);

        // then
        assertAll(
                () -> assertThat(4).isEqualTo(matchingItems.getMatchingItems().size()),
                () ->  {
                    for (String gameResult : matchingItems.getMatchingItems()) {
                        assertThat(Arrays.stream(gameResultNames.split(",")).collect(Collectors.toList()).contains(gameResult)).isTrue();
                    }
                }
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:5000", "2:꽝", "3:3000"}, delimiter = ':')
    @DisplayName("게임결과 단건조회 테스트")
    void getGameResult(int ladderExitNumber, String gameResult) {
        // given
        LadderGenerationService service = new LadderGenerationService();
        String gameResultNames = "꽝,5000,꽝,3000";

        // when
        MatchingItems matchingItems = service.generateMatchingItems(gameResultNames, 4);

        // then
        assertThat(gameResult).isEqualTo(matchingItems.getGameResult(ladderExitNumber));
    }

}