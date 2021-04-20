package ladder.service;

import ladder.domain.*;
import ladder.controller.dto.LadderGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameServiceTest {

    @Test
    @DisplayName("정상실행 - 서비스 실행 결과 참가자 수 검증")
    void participantCount() {
        // given
        LadderGameService service = new LadderGameService();

        // when
        Participants participants = service.registerParticipants("pobi,honux,crong,jk");

        // then
        assertThat(4).isEqualTo(participants.getCount());
    }

    @Test
    @DisplayName("정상실행 - 서비스 실행 결과 사다리 높이 검증")
    void ladderHeight() {
        // given
        LadderGameService service = new LadderGameService();

        // when
        Ladder ladder = service.generateLadder(4, 5);

        // then
        assertThat(5).isEqualTo(ladder.getLines().size());
    }

    @Test
    @DisplayName("참가자 정보 미입력")
    void participantsIsNull() {
        // given
        LadderGameService service = new LadderGameService();

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
        LadderGameService service = new LadderGameService();

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
        LadderGameService service = new LadderGameService();

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
        LadderGameService service = new LadderGameService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateMatchingItems(gameResultNames, 5))
                .withMessageMatching("게임 결과를 입력해 주세요.");
    }

    @Test
    @DisplayName("게임 결과와 참가자 수가 일치하지 않을 때")
    void participantsCount_invalid() {
        // given
        LadderGameService service = new LadderGameService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateMatchingItems("꽝,5000,꽝,3000", 5))
                .withMessageMatching("게임 결과 수는 참가자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("게임 결과에 빈 값 또는 공백 존재")
    void gameResultNames_hasEmpty() {
        // given
        LadderGameService service = new LadderGameService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.generateMatchingItems("꽝,,   ,3000", 4))
                .withMessageMatching("유효하지 않은 결과값이 존재합니다. 입력값을 확인해주세요.");
    }

    @Test
    @DisplayName("게임결과 정상생성 테스트")
    void gameResults() {
        // given
        LadderGameService service = new LadderGameService();
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
        LadderGameService service = new LadderGameService();
        String gameResultNames = "꽝,5000,꽝,3000";

        // when
        MatchingItems matchingItems = service.generateMatchingItems(gameResultNames, 4);

        // then
        assertThat(gameResult).isEqualTo(matchingItems.getGameResult(ladderExitNumber));
    }

    @Test
    @DisplayName("사다리게임 결과 리스트 조회")
    void inquiryGameResults() {
        // given
        List<String> expectedList = Arrays.asList("꽝", "3000", "꽝", "5000");
        LadderGameService service = new LadderGameService();

        Participants participants = new Participants("pobi,honux,crong,jk");
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        Ladder ladder = new Ladder(lines);
        MatchingItems matchingItems = new MatchingItems("꽝,5000,꽝,3000", participants.getCount());

        // when
        List<LadderGameResult> gameResults = service.executeGame(participants, ladder, matchingItems);

        // then
        for (int i = 0; i < expectedList.size(); i++) {
            assertThat(expectedList.get(i)).isEqualTo(gameResults.get(i).getMatchingItem());
        }
    }

    @Test
    @DisplayName("사다리게임 실행결과는 수정 불가능")
    void gameResultsIsUnmodifiable() {
        // given
        LadderGameService service = new LadderGameService();

        Participants participants = new Participants("pobi,honux,crong,jk");
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, false)),
                new Point(1, new Direction(false, true)),
                new Point(2, new Direction(true, false)),
                new Point(3, new Direction(false, false))
        )));
        lines.add(new Line(Arrays.asList(
                new Point(0, new Direction(false, true)),
                new Point(1, new Direction(true, false)),
                new Point(2, new Direction(false, true)),
                new Point(3, new Direction(true, false))
        )));
        Ladder ladder = new Ladder(lines);
        MatchingItems matchingItems = new MatchingItems("꽝,5000,꽝,3000", participants.getCount());

        // when
        List<LadderGameResult> gameResults = service.executeGame(participants, ladder, matchingItems);

        // then
        assertThrows(UnsupportedOperationException.class, () -> gameResults.add(new LadderGameResult("test", "1000")));
        assertThrows(UnsupportedOperationException.class, () -> gameResults.remove(0));
    }
}