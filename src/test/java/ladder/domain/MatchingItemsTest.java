package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class MatchingItemsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("게임결과 생성 - null 또는 공백입력")
    void nullOrEmpty(String gameResultNames) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MatchingItems(gameResultNames, 5))
                .withMessageMatching("게임 결과를 입력해 주세요.");
    }

    @Test
    @DisplayName("게임 결과와 참가자 수가 일치하지 않을 때")
    void participantsCount_invalid() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MatchingItems("꽝,5000,꽝,3000", 5))
                .withMessageMatching("게임 결과 수는 참가자 수와 같아야 합니다.");
    }

    @Test
    @DisplayName("게임 결과에 빈 값 또는 공백 존재")
    void gameResultNames_hasEmpty() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MatchingItems("꽝,,   ,3000", 4))
                .withMessageMatching("유효하지 않은 결과값이 존재합니다. 입력값을 확인해주세요.");
    }

    @Test
    @DisplayName("게임결과 정상생성 테스트")
    void gameResults() {
        // given when
        String gameResultNames = "꽝,5000,꽝,3000";
        MatchingItems matchingItems = new MatchingItems(gameResultNames, 4);

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
        String gameResultNames = "꽝,5000,꽝,3000";
        MatchingItems matchingItems = new MatchingItems(gameResultNames, 4);

        // then
        assertThat(gameResult).isEqualTo(matchingItems.getGameResult(ladderExitNumber));
    }
}